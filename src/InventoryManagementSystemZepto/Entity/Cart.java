package InventoryManagementSystemZepto.Entity;

import java.util.ArrayList;
import java.util.List;

import static InventoryManagementSystemZepto.Factory.ProductFactory.createProduct;

public class Cart {
    public List<Pair<Product,Integer>> items = new ArrayList<>();

    public List<Pair<Product, Integer>> getItems() {
        return items;
    }

    public double getTotal(){
        double total =0.0;
        for(Pair<Product,Integer> it: items){
            total += (it.getKey().getPrice())*it.getValue();
        }
        return total;
    }

    public void addItem(int sku, int qty){
        Product product = createProduct(sku);
        items.add(new Pair<>(product,qty));
    }
}
