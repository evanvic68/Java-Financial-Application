package Model;

import java.io.*;
import java.util.*;

public class assetLinkedList {
    private LinkedList<Asset> alList;

    public assetLinkedList(){
        alList = new LinkedList<>();
        buildList();
        printList();
    }

    private void buildList() {
        addItem(new Asset("Stock One", "Stock", 100, 0));
        addItem(new Asset("Stock Two", "Stock", 60, 0));
        addItem(new Asset("Stock Three", "Stock", 900, 0));
    }

    public void printList() {
        for (Asset asset : alList) {
            System.out.println(asset);
        }
    }


    public void addItem(Asset a1){
        for(int i = 0; i < alList.size(); i++){
            if(a1.compareTo(alList.get(i)) <= 0){
                alList.add(i, a1);
                return;
            }
        }
        alList.add(a1);
    }

    public void removeItem(Asset a1){
        alList.remove(a1);
    }

    public Asset getItem(String assetName){
        for(Asset a1: alList){
            if(a1.getAssetName().equals(assetName)){
                return a1;
            }
        }

        return null;
    }
}
