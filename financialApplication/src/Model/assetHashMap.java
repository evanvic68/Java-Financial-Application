package Model;

import javax.swing.*;
import java.util.HashMap;


public class assetHashMap {
    private HashMap<String, Asset> ah1;

    public assetHashMap(){
        ah1 = new HashMap<>();
        ah1.put("asset", new Asset("Stock One", "Car Payment", 0, 10));
        ah1.put("asset2", new Asset("Stock Two", "Car Payment", 0, 10));
        ah1.put("asset3", new Asset("Stock Three", "Car Payment", 0, 10));
    }

    public void addAssets(String name, Asset a){
        ah1.put(name, a);
    }

    public void removeAssets(String name){
        ah1.remove(name);
    }


    public Asset searchMap(String name){
        for (Asset a : ah1.values()) {
            if (a.getAssetName().equals(name)) {
                return a;
            }
        }
        return null;
    }


    @Override
    public String toString(){
        StringBuilder mapList = new StringBuilder("Asset List:\n");
        for (Asset a : ah1.values()) {
            mapList.append(a).append("\n\n");
        }
        return mapList.toString();
    }

    public HashMap<String, Asset> getAh1(){
        return ah1;
    }
}
