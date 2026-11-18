package InventoryManagementSystemZepto.Entity;

import InventoryManagementSystemZepto.Interface.ReplenishStrategy;
import InventoryManagementSystemZepto.Manager.InventoryManager;

import java.util.List;
import java.util.Map;

public class DarkStore {
    private String name;
    private double x,y;
    private InventoryManager inventoryManager;
    private ReplenishStrategy replenishStrategy;

    public DarkStore(String n, double x_coord, double y_coord){
        name = n;
        x    = x_coord;
        y    = y_coord;
        inventoryManager = new InventoryManager(new DbInventoryStore());
    }

    public double distanceTo(double ux, double uy){
        return Math.sqrt((x - ux)*(x - ux) + (y - uy)*(y - uy));
    }

    public void runReplenishment(Map<Integer,Integer> itempsToReplenish){
        if(replenishStrategy != null){
            replenishStrategy.replenish(inventoryManager, itempsToReplenish);
        }
    }

    // now we will make delegation methods since for any kind of stock change the dbStoreManager won't be
    // talking to each of the inventoryManager, instead it will instruct each and every dark store to change stock
    // and dark store will reroute the methods to their respective inventoryManager

    public List<Product> getAllProducts() {
        return inventoryManager.getAvailableProducts();
    }

    public int checkStock(int sku) {
        return inventoryManager.checkStock(sku);
    }

    public void removeStock(int sku, int qty) {
        inventoryManager.removeStock(sku, qty);
    }

    public void addStock(int sku, int qty) {
        inventoryManager.addStock(sku, qty);
    }
    public void setReplenishStrategy(ReplenishStrategy strategy) {
        this.replenishStrategy = strategy;
    }

    public String getName() {
        return this.name;
    }

    public double getXCoordinate() {
        return this.x;
    }

    public double getYCoordinate() {
        return this.y;
    }

    public InventoryManager getInventoryManager() {
        return this.inventoryManager;
    }
}
