package InventoryManagementSystemZepto.Interface;

import InventoryManagementSystemZepto.Entity.Product;

import java.util.List;

public interface InventoryStore {

    void addProduct(Product prd, int qty);
    void removeProduct(int sku, int qty);
    int checkStock(int sku);
    List<Product> listAvailableProducts();
}
