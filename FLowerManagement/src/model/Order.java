
package model;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Set;

public class Order implements Serializable{
    private OrderHeader orderHeader;
    private HashMap<String, OrderDetail> orderDetail;
    int cost = 0;

    public Order() {
    }

    public Order(OrderHeader orderHeader, HashMap<String, OrderDetail> orderDetail) {
        this.orderHeader = orderHeader;
        this.orderDetail = orderDetail;
    }

    
    public OrderHeader getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(OrderHeader orderHeader) {
        this.orderHeader = orderHeader;
    }

    public HashMap<String, OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(HashMap<String, OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
    
    public int getFlowerCount() {
        int sum = 0;
        for(int i=0; i < orderDetail.size(); i++) {
            sum += orderDetail.get(i).getQuantity();
        }
        return sum;
    }
    
    public double getTotalFlowerCost() {
        int sum = 0;
        for(int i=0; i < orderDetail.size(); i++) {
            sum += orderDetail.get(i).getFlowerCost();
        }
        return sum;
    }
    
//    public double getFlowerCost(Set<Flower> listFlower, HashMap<String, OrderDetail> orderDHashMap ) {
//        int count = 0;
//        for(OrderDetail orderDetail1 : orderDHashMap.values()) {
//            count += order
//        }
//    }
    

    @Override
    public String toString() {
        return String.format("| %s | %-10d | %12s |", orderHeader.toString(), getOrderDetail().size(), cost);
    }
    

    
    }

   
    
    



   

