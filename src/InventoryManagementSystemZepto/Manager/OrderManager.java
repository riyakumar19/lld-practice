package InventoryManagementSystemZepto.Manager;

import InventoryManagementSystemZepto.Entity.Order;

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
}
