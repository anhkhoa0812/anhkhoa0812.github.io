
package model;

import java.io.Serializable;

public class OrderHeader implements Serializable{
    private String orderID, orderDate, name;
   

    public OrderHeader() {
    }

    public OrderHeader(String orderID, String orderDate, String name) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.name = name;
    }
    

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("| %-9s | %11s | %-15s |", getOrderID(), getOrderDate(), getName());
    }

   
    

}
