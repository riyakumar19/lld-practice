package Tomato.Models;

public class MenuItem {
    int restaurantId;
    String name;
    Double price;
    String code;

    public MenuItem(String code, String name, Double price, int id) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.restaurantId = id;
    }

    public Double getPrice(){
        return this.price;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String c) {
        this.code = c;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setPrice(Double p) {
        this.price = p;
    }
}
