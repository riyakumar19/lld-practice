package InventoryManagementSystemZepto.Entity;

import InventoryManagementSystemZepto.Interface.ReplenishStrategy;
import InventoryManagementSystemZepto.Manager.InventoryManager;

import java.util.Map;

public class WeeklyReplenishStrategy implements ReplenishStrategy {
    public void replenish(InventoryManager manager, Map<Integer,Integer> itemsToReplenish){
        System.out.println("[WeeklyReplenish] Weekly replenishment triggered for inventory.");
        for(Map.Entry<Integer,Integer> it : itemsToReplenish.entrySet()){
            int sku = it.getKey(); int quantityToReplenish = it.getValue();
            manager.addStock(sku,quantityToReplenish);
        }
    }
}
