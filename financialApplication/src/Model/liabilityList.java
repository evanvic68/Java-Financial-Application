package Model;

import java.io.*;
import java.util.ArrayList;

public class liabilityList{
    private ArrayList<Liability> lList;
    private String fileName = "liabilityList.ser";

    public liabilityList(){
        lList = new ArrayList<>();

        this.readlListFile();
        if(lList.isEmpty()){
            this.writelListFile();
            this.readlListFile();
        }

       this.printLiabilityList();
    }

    public void writelListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(lList);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readlListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            lList = (ArrayList) in.readObject();
            in.close();
            if (!lList.isEmpty()) {
                System.out.println("There are liabilities in the liability list");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File not present. Creating new file.");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void printLiabilityList() {
        System.out.println("The liabilityList has these liabilities:");
        for (int i = 0; i < lList.size(); i++) {
            Liability currentUser = (Liability) lList.get(i);
            System.out.println(currentUser.getLiabilityName());
        }
    }

    public ArrayList<Liability> getlList(){
        return lList;
    }
}
