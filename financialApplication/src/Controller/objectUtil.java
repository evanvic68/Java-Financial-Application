package Controller;

import Model.Employee;

import java.io.*;

public class objectUtil {
    public Object readEmployeeFile(String filename) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object e1 = ois.readObject();
        ois.close();
        return e1;
    }

    public void writeEmployeeFile(Employee e1, String filename) throws IOException{
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(e1);
        fos.close();
    }
}
