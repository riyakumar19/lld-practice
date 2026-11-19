package InventoryManagementSystemZepto.Manager;

import InventoryManagementSystemZepto.Entity.*;
import InventoryManagementSystemZepto.Factory.ProductFactory;


import java.util.*;

// a signleton class because every order cannot have an ordermanager
public class OrderManager {
    private static OrderManager instance;
    private List<Order> orders;

    private OrderManager() {
        orders = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void placeOrder(User user, Cart cart){
        List<Pair<Product,Integer>> requestedItems = cart.getItems();
        double maxDist = 5.0;
        List<DarkStore> nearbyDarkStores = DarkStoreManager.getInstance().getNearbyDarkStore(user.x, user.y, maxDist);
        DarkStore firstStore = nearbyDarkStores.get(0);
        boolean allFoundInOneDarkStore = true;
        for(Pair<Product, Integer> item : requestedItems){
            int sku = item.getKey().getSku();
            int qty = firstStore.checkStock(sku);
            if(qty< item.getValue()) {
                allFoundInOneDarkStore = false;
                break;
            }
        }
        Order order = new Order(user);
        if(allFoundInOneDarkStore){
            double totalAmt = 0;
            for (Pair<Product,Integer> item : requestedItems) {
                int sku = item.getKey().getSku();
                int qty = item.getValue();
                firstStore.removeStock(sku, qty);
                totalAmt += item.getKey().getPrice()* item.getValue();
                order.items.add(new Pair<>(item.getKey(), qty));
            }
            order.partners.add(new DeliveryPartner("Delivery Partner 1 : Ramesh Lala"));
            order.setTotalAmount(totalAmt);
        }
        else{
            System.out.println("  Splitting order across stores...");
            Map<Integer,Integer> allItems = new HashMap<>();
            int partnerId = 1;
            for (Pair<Product,Integer> item : requestedItems) {
                allItems.put(item.getKey().getSku(), item.getValue());
            }
            for(DarkStore store : nearbyDarkStores){
                if (allItems.isEmpty()) break;
                System.out.println("   Checking: " + store.getName());
                List<Integer> toErase = new ArrayList<>();
                for(Map.Entry<Integer,Integer> entry : allItems.entrySet()){
                    int sku = entry.getKey();
                    int qtyNeeded = entry.getValue();
                    int availableQty = store.checkStock(sku);
                    if (availableQty <= 0) continue;
                    int takenQty = Math.min(availableQty, qtyNeeded);
                    store.removeStock(sku,takenQty);
                    System.out.println("     " + store.getName() + " supplies SKU " + sku
                            + " x" + takenQty);
                    order.items.add( new Pair<>(ProductFactory.createProduct(sku),takenQty ) );
                    if (qtyNeeded > takenQty) {
                        allItems.put(sku, qtyNeeded - takenQty);
                    } else {
                        toErase.add(sku);
                    }
                }
                for (int sku : toErase) {
                    allItems.remove(sku);
                }
                // after iterating over every dark store we will assign a delivery partner for those items
                if (!toErase.isEmpty()) {
                    String pname = "Partner" + partnerId++;
                    order.partners.add(new DeliveryPartner(pname));
                    System.out.println("     Assigned: " + pname + " for " + store.getName());
                }
            }
            if (!allItems.isEmpty()) {
                System.out.println("  Could not fulfill:");
                for (Map.Entry<Integer,Integer> entry : allItems.entrySet()) {
                    System.out.println("    SKU " + entry.getKey()
                            + " x" + entry.getValue());
                }
            }
            double sum = 0;
            for (Pair<Product,Integer> it : order.items) {
                sum += it.getKey().getPrice() * it.getValue();
            }
            order.totalAmount = sum;
        }
        System.out.println("\n[OrderManager] Order #" + order.orderId + " Summary:");
        System.out.println("  User: " + user.name + "\n  Items:");
        for (Pair<Product,Integer> item : order.items) {
            System.out.println("    SKU " + item.getKey().getSku()
                    + " (" + item.getKey().getName() + ") x" + item.getValue()
                    + " @ ₹" + item.getKey().getPrice());
        }
        System.out.println("  Total: ₹" + order.totalAmount + "\n  Partners:");
        for (DeliveryPartner dp : order.partners) {
            System.out.println("    " + dp.name);
        }
        System.out.println();

        orders.add(order);


    }
    public List<Order> getAllOrders() {
        return orders;
    }
}
