/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

public class OrderDetail implements Serializable{
    private String ordetailID, flowerID;
    private int quantity;
    private double flowerCost;
    Flower flower = new Flower();

    public OrderDetail() {
    }

    
    
    public OrderDetail(String ordetailID, String flowerID, int quantity, double flowerCost) {
        this.ordetailID = ordetailID;
        this.flowerID = flowerID;
        this.quantity = quantity;
        this.flowerCost = flowerCost;
    }
    
    

    public String getOrdetailID() {
        return ordetailID;
    }

    public void setOrdetailID(String ordetailID) {
        this.ordetailID = ordetailID;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getFlowerCost() {
        return quantity * flower.getUnitPrice();
    }

    public void setFlowerCost(double flowerCost) {
        this.flowerCost = flowerCost;
    }

   
    
    
    
}
