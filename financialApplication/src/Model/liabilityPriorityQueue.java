package Model;

import javax.swing.*;
import java.util.PriorityQueue;

public class liabilityPriorityQueue {
    private PriorityQueue<Liability> q1;

    public liabilityPriorityQueue(){
        q1 = new PriorityQueue<>();
        q1.offer(new Liability("Car", "Car Payment", 0, 10));
        q1.offer(new Liability("Phone", "Bill", 0, 90));
        q1.offer(new Liability("Cable", "Bill", 0, 6));
    }

    public void addLiability(Liability l1){
        q1.offer(l1);
    }

    public void removeLiability(Liability l1){
        q1.remove(l1);
    }

    public Liability searchLiability(String name){
        for(Liability l1: q1){
            if(l1.getLiabilityName().equals(name)){
                return l1;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        String queueList = "HIGHEST PRIORITY!!!! PLEASE PAY THIS OFF SOON.\n";
        for(Liability l1: q1){
            queueList += l1 + "\n\n";
        }
        return queueList;
    }

    public PriorityQueue<Liability> getLiabilities(){
        return q1;
    }
}
