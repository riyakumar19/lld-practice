package Tomato.Models;

public class User {
    Cart cart;
    int userId;
    String address;

    public User(int userId, String address) {
        this.userId = userId;
        this.address = address;
        this.cart = new Cart();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        address = a;
    }

    public Cart getCart() {
        return cart;
    }
}
