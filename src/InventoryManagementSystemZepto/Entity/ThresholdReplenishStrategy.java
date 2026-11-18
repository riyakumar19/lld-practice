package InventoryManagementSystemZepto.Entity;

import InventoryManagementSystemZepto.Interface.ReplenishStrategy;
import InventoryManagementSystemZepto.Manager.InventoryManager;

import java.util.Map;

public class ThresholdReplenishStrategy implements ReplenishStrategy {
    int threshold;
    public ThresholdReplenishStrategy(int threshold){
        this.threshold = threshold;
    }
    @Override
    public void replenish(InventoryManager manager, Map<Integer,Integer> itemsToReplenish){
        System.out.println("[ThresholdReplenish] Checking threshold...");
        for(Map.Entry<Integer,Integer> it: itemsToReplenish.entrySet()){
            int sku = it.getKey(); int quantitytoReplenish = it.getValue();
            int currentStock = manager.checkStock(sku);
            if(currentStock < threshold){
                manager.addStock(sku,quantitytoReplenish);
                System.out.println("Quantity for sku " + sku + " was " + currentStock + ", replenished by " + quantitytoReplenish);
            }
        }
    }
}
