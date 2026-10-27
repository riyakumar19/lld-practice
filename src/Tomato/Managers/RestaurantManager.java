package Tomato.Managers;

import Tomato.Models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager() {
    }

    public static RestaurantManager getInstance(){
        if(instance== null){
            return new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant r){
        restaurants.add(r);
    }

    public List<Restaurant> getRestaurantByLocation(String location){
        List<Restaurant> restaurantList = new ArrayList<>();
        for(Restaurant r : restaurants){
            if(r.getLocation()== location){
                restaurantList.add(r);
            }
        }
        return restaurantList;
    }
}
