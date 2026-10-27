package Tomato.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    ArrayList<MenuItem> items = new ArrayList<>();
    Integer restaurantId;

    public boolean isEmpty(){
        return (items.size()==0);
    }

    public void addtoCart(MenuItem item){
        this.items.add(item);
        if(restaurantId==null) {
            this.restaurantId = item.restaurantId;
        }
    }

    public Double getTotalCost(){
        Double sum =0.0;
        for(int i = 0; i<this.items.size(); i++) sum+=items.get(i).getPrice();

        return sum;
    }

    public void clear() {
        items.clear();
        restaurantId = null;
    }
    public List<MenuItem> getItems() {
        return items;
    }
}
