package Tomato.Models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    ArrayList<MenuItem> menu = new ArrayList<>();
    String location;
    int restaurantId;
    String name;
    private static int nextId;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.restaurantId = ++nextId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }

    public void addMenuItem(MenuItem item) {
        this.menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return this.menu;
    }
}
