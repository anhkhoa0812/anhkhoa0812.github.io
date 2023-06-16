/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.HashSet;
import model.Flower;
import model.Order;
import util.Validation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.OrderDetail;
import view.Menu;

public class FlowerSet extends HashSet<Flower> implements Serializable{

    public FlowerSet addFlower() {

        String flowerID = Validation.checkString("Please enter the ID of Flower:");

        if (existID(flowerID)) {
            System.out.println("This ID is duplicated");
        } else {
            String description = Validation.checkStringLength("Please enter the Description of Flower:");
            String importDate = Validation.checkDate("Please enter the Import Date of Flower:");
            double unitPrice = Validation.checkDouble("Please enter the Unit Price of Flower:");
            String category = Validation.checkString("Please enter the Category of Flower:");

            Flower flower = new Flower(flowerID, description, importDate, unitPrice, category);

            this.add(flower);
        }
        return this;
    }

    public void findFlower() {
        if (this.isEmpty() || this == null) {
            System.out.println("No flower in the store!");
        } else {
            String options = Validation.checkString("You want find Flower by ID or Name (id/name):");
            if (options.equalsIgnoreCase("id")) {
                findFlowerByID();
            } else if (options.equalsIgnoreCase("name")) {
                findFlowerByName();
            } else {
                System.out.println("Please enter id or name only!");
            }
        }

    }

    private void findFlowerByID() {

        String flowerID = Validation.checkString("Please enter the ID of Flower to find:");
        int count = 0;
        for (Flower flower : this) {
            if (flower.getId().equalsIgnoreCase(flowerID)) {
                System.out.println(flower.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("The flower does not exist");
        }

    }

    private void findFlowerByName() {

        String description = Validation.checkStringLength("Please enter Description of Flower to find:");
        int count = 0;

        for (Flower flower : this) {
            if (flower.getDescription().contains(description)) {
                System.out.println(flower.toString());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("The flower does not exist");
        }

    }
    public void printFlower() {
        if(this.isEmpty()) {
            System.out.println("No flower in the store");
        }
        else {
            
        for (Flower thi : this) {
            System.out.println(thi.toString());
        }
        }
    }

    public void updateFlower() {
        if (this.isEmpty()) {
            System.out.println("No flower in the store!");
        } else {
            String description = Validation.checkStringLength("Please enter Description of Flower to update:");
            int count = 0;
            
            for (Flower flower : this) {
                
                if (flower.getDescription().equalsIgnoreCase(description)) {
                    Menu.updateFlowerMenu();
                    updateOptions(flower);
                    count++;
                    

                }
                else
                    System.out.println("The flower does not exist");
                break;
            }
        }
    }

    public void deleteFLower(OrderSet orderSet) {
        if (this.isEmpty()) {
            System.out.println("No flower in the store");
        } else {
            String flowerID = Validation.checkString("Please enter the ID of Flower to delete:");
            int count = 0;
            for (Flower flower : this) {
                if(flower.getId().equalsIgnoreCase(flowerID)) {
                    if(existOrderDetail(flowerID, orderSet)) {
                        System.out.println("This flower already exist in the Order. Cannot delete");
                    }
                    else {
                    this.remove(flower); 
                    count++;
                    }                   
                }
                
            }
            if(count == 0) {
                System.out.println("The flower does not exist");
            }
            

        }

    }

    public boolean existID(String flowerID) {
        for (Flower flower : this) {
            if (flowerID.equalsIgnoreCase(flower.getId())) {
                return true;
            }
        }
        return false;
    }



    private void updateOptions(Flower flower) {
        
        int choice = Validation.checkInt("Which you want to update:");

        switch (choice) {
            case 1:
                try {
                    String description = Validation.checkStringLength("Please enter new Description to update:");
                    flower.setDescription(description);
                    System.out.println("Success");
                } catch (Exception e) {
                    System.out.println("Failure");
                }
                break;
            case 2:
                try {

                    String importDate = Validation.checkString("Please enter new Import Date to update:");
                    flower.setImportDate(importDate);
                    System.out.println("Success");
                } catch (Exception e) {
                    System.out.println("Failure");
                }

                break;
            case 3:
                try {

                    double unitPrice = Validation.checkDouble("Please enter new Unit Price to update:");
                    flower.setUnitPrice(unitPrice);
                    System.out.println("Success");
                } catch (Exception e) {
                    System.out.println("Failure");
                }
                break;
            case 4:
                try {

                    String category = Validation.checkString("Please enter new Category to update:");
                    flower.setCategory(category);
                    System.out.println("Success");
                } catch (Exception e) {
                    System.out.println("Failure");
                }
                break;

        }
    }

    private boolean existOrderDetail(String flowerID, OrderSet orderSet) {
       
        for(Order order: orderSet) {
            for(OrderDetail orderDetail : order.getOrderDetail().values()) {
                if(flowerID.equalsIgnoreCase(orderDetail.getFlowerID())) {
                    return true;
                }
            }
        }
        return false;
            
        }
    
    public void saveFlower(FlowerSet flowerSet)  {

        try {
            File file = new File("src\\output\\flowers.dat"); //The binary file
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Flower flower : flowerSet) {
                oos.writeObject(flower);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Failed to save. Error writing file.");
        }
    }
    
     public FlowerSet loadData(FlowerSet flowerSet) throws IOException {

        File file = new File("src\\output\\flowers.dat"); //The binary file

        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
            boolean isFinish = false;
            do {                
                
                try {

                    Object ob = ois.readObject();
                    if (ob instanceof Flower) {
                        Flower flower = (Flower) ob;
                        flowerSet.add(flower);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    isFinish = true;
                }
            } while (!isFinish);
            
            System.out.println("Loaded flower data!");
        } catch (Exception e) {
            System.out.println("Failed to load. Error reading file.");
        }
        return flowerSet;
    }


}
