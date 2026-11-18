package InventoryManagementSystemZepto.Manager;

import InventoryManagementSystemZepto.Entity.DarkStore;
import InventoryManagementSystemZepto.Entity.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DarkStoreManager {
    private static DarkStoreManager instance;
    List<DarkStore> darkStoreList = new ArrayList<DarkStore>();
    public DarkStoreManager getInstance(){
        if(instance == null){
            return instance =  new DarkStoreManager();
        }
        return instance;
    }

    public void registerDarkStore(DarkStore ds){
        darkStoreList.add(ds);
    }

    public List<DarkStore> getNearbyDarkStore(double ux, double uy, double maxDistance){
        List<DarkStore> result = new ArrayList<DarkStore>();
        List<Pair<Double,DarkStore>> distList = new ArrayList<>();
        for(DarkStore d : darkStoreList){
            double dist = d.distanceTo(ux,uy);
            if(dist<= maxDistance){
                distList.add(new Pair<>(dist,d));
            }
        }
        distList.sort(Comparator.comparing(Pair :: getKey));
        for (Pair<Double,DarkStore> p : distList) {
            result.add(p.getValue());
        }
        return result;
    }





}
