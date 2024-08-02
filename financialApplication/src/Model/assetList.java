package Model;

import java.io.*;
import java.util.ArrayList;

public class assetList{
    private ArrayList<Asset> aList;
    private String fileName = "assetList.ser";

    public assetList(){
        aList = new ArrayList<>();

        this.readAssetFile();
        if(aList.isEmpty() || aList == null){
            this.writeAssetFile();
            this.readAssetFile();
        }
        this.printAssetList();
    }

    public void readAssetFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            aList = (ArrayList) in.readObject();
            in.close();
            if (!aList.isEmpty()) {
                System.out.println("The assetList is empty.");
            }
        } catch (FileNotFoundException fne) {
            System.out.println("File not present. Creating new file.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public void writeAssetFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(aList);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void printAssetList() {
        System.out.println("The assetList has these assets: ");
        for (int i = 0; i < aList.size(); i++) {
            Asset a = (Asset) aList.get(i);
            System.out.println(a.getAssetName());
        }
    }

    public ArrayList<Asset> getAList(){
        return aList;
    }
}
