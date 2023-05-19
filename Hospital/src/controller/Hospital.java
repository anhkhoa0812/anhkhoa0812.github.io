
package controller;

import business.NurseList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Hospital {
    public NurseList readNurseFromFile(String path) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        NurseList nl = (NurseList) objectInputStream.readObject();
        
        return nl;
    }
    
    public void writeNurseToFile(String path, Object object) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        
    } 
}
