package business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import model.Flower;
import model.Order;
import model.OrderDetail;
import model.OrderHeader;
import util.Validation;
import view.Menu;

public class OrderSet extends HashSet<Order> implements Serializable {

    public OrderSet addOrder(OrderSet orderSet, FlowerSet flowerSet) {

        String orderID = Validation.checkString("Please enter the ID of Order:");
        if (existID(orderID)) {
            System.out.println("The header oder is duplicated");
        } else {

            HashMap<String, OrderDetail> orderDetailHashMap = new HashMap<String, OrderDetail>();
            String orderDate = Validation.checkDate("Please enter the Order Date of Order:");
            String name = Validation.checkString("Please enter the customer's name of Order:");
            OrderHeader orderHeader = new OrderHeader(orderID, orderDate, name);
            String continueCheck;
            String orderDetailID;
            OrderDetail orderDetail = null;
            do {

                orderDetailID = Validation.checkString("Please enter the ID of Order Detail:");

                if (existDetailID(orderDetailID)) {
                    System.out.println("The detail order is duplicated");
                } else {

                    String flowerID = Validation.checkString("Please enter the ID of Flower of Order:");

                    if (!existFlowerID(flowerID, flowerSet)) {
                        System.out.println("The flower does not exist");
                    } else {

                        int quantity = Validation.checkInt("Please enter the quantity of Order:");

                        double unitPrice = 0;
                        for (Flower flower : flowerSet) {
                            if (flower.getId().equalsIgnoreCase(flowerID)) {
                                unitPrice = flower.getUnitPrice();
                                break;
                            }
                        }
                        double flowerCost = quantity * unitPrice;
                        orderDetail = new OrderDetail(orderDetailID, flowerID, quantity, flowerCost);
                    }
                }
                continueCheck = Validation.checkString("Do you want to continue add Flower? (Y/n): ");
            } while (continueCheck.equalsIgnoreCase("Y"));

            orderDetailHashMap.put(orderDetailID, orderDetail);
            Order order = new Order(orderHeader, orderDetailHashMap);
            orderSet.add(order);
        }
        return orderSet;

    }

//    private void addOrderHeader(String orderID, OrderHeader orderHeader) {
//        String orderDate = Validation.checkDate("Please enter the Order Date of Order:");
//        String name = Validation.checkString("Please enter the customer's name of Order:");
//        orderHeader = new OrderHeader(orderID, orderDate, name);
//    }
//
//    private void addOrderDetail(String orderDetailID, HashMap<String, OrderDetail> orderDetail) {
//        FlowerSet flowerSet = new FlowerSet();
//        String flowerID = Validation.checkString("Please enter the ID of Flower of Order:");
//
//        int quantity = Validation.checkInt("{lease enter the quantity of Order:");
//        double unitPrice = 0;
//        for (Flower flower : flowerSet) {
//            if (flower.getId().equalsIgnoreCase(flowerID)) {
//                unitPrice = flower.getUnitPrice();
//            }
//        }
//        double flowerCost = quantity * unitPrice;
//
//        HashMap<String, OrderDetail> orderHashMap = new HashMap<String, OrderDetail>();
//        OrderDetail orderDetail1 = new OrderDetail(orderDetailID, flowerID, quantity, flowerCost);
//        orderHashMap.put(orderDetailID, orderDetail1);
//
//    }
    public void displayOrders() throws ParseException {
        String startDateString = Validation.checkDate("Please enter the Start date:");
        String endDateString = Validation.checkDate("Please enter the End date:");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = sdf.parse(startDateString);
        Date endDate = sdf.parse(endDateString);

        Menu.showDisplayOrdersMenu(startDate, endDate);
        int count = 1;
        HashMap<String, OrderDetail> orderDetailHashMap = new HashMap<String, OrderDetail>();
        for (Order order : this) {
            for (OrderDetail orderDetail : order.getOrderDetail().values()) {

                Date orderDate = sdf.parse(order.getOrderHeader().getOrderDate());
                if (orderDate.before(endDate) && orderDate.after(startDate)) {
                    System.out.printf("| %5d | %-9s | %11s | %-15s | %-10d | %12s | \n", count,
                            order.getOrderHeader().getOrderID(), order.getOrderHeader().getOrderDate(),
                            order.getOrderHeader().getName(),order.getOrderDetail().size(), orderDetail.getFlowerCost());
                    count++;
                    System.out.println("-----------------------------------------------------------------------------------");

                }
            }

        }
    }

    public void sortOrders() {
        ArrayList<Order> orders = new ArrayList<>(this);
        ArrayList<Order> orders1 = new ArrayList<>(this);
        if (orders.isEmpty()) {
            System.out.println("No order in the store");
        } else {
            String sortedField = Validation.checkString("Please enter the Sorted Field to sort(id, name, date, name or total):");
            String sortOrder = Validation.checkString("Please enter the Sort Order to sort(ASC or DECS):");

            if (sortedField.equalsIgnoreCase("id") || sortedField.equalsIgnoreCase("name")
                    || sortedField.equalsIgnoreCase("date") || sortedField.equalsIgnoreCase("name")
                    || sortedField.equalsIgnoreCase("total") || sortOrder.equalsIgnoreCase("ASC")
                    || sortOrder.equalsIgnoreCase("DESC")) {

                Menu.showSortMenu(sortedField, sortOrder);

                if (sortedField.equalsIgnoreCase("id") && sortOrder.equalsIgnoreCase("ASC")) {
                    sortByIDwithASC(orders);

                    for (Order order : this) {

                        System.out.printf("| %5s | %-9s | %11s | %-15s | %-10s | %12s | \n", orders1.indexOf(orders) + 1,
                                order.getOrderHeader().getOrderID(), order.getOrderHeader().getOrderDate(),
                                order.getOrderHeader().getName(), order.getFlowerCount(), order.getTotalFlowerCost());
                        System.out.println("-----------------------------------------------------------------------------------");
                    }
                }

                if (sortedField.equalsIgnoreCase("id") && sortOrder.equalsIgnoreCase("DESC")) {
                    sortByIDwithDESC(orders);

                    for (Order order : this) {

                        System.out.printf("| %5s | %-9s | %11s | %-15s | %-10s | %12s | \n", orders1.indexOf(orders) + 1,
                                order.getOrderHeader().getOrderID(), order.getOrderHeader().getOrderDate(),
                                order.getOrderHeader().getName(), order.getFlowerCount(), order.getTotalFlowerCost());
                        System.out.println("-----------------------------------------------------------------------------------");
                    }
                }
                if (sortedField.equalsIgnoreCase("date") && sortOrder.equalsIgnoreCase("ASC")) {
                    sortByDatewithASC(orders);

                    for (Order order : this) {

                        System.out.printf("| %5s | %-9s | %11s | %-15s | %-10s | %12s | \n", orders1.indexOf(orders) + 1,
                                order.getOrderHeader().getOrderID(), order.getOrderHeader().getOrderDate(),
                                order.getOrderHeader().getName(), order.getFlowerCount(), order.getTotalFlowerCost());
                        System.out.println("-----------------------------------------------------------------------------------");
                    }
                }
                if (sortedField.equalsIgnoreCase("date") && sortOrder.equalsIgnoreCase("DESC")) {
                    sortByDatewithDESC(orders);

                    for (Order order : this) {

                        System.out.printf("| %5s | %-9s | %11s | %-15s | %-10s | %12s | \n", orders1.indexOf(orders) + 1,
                                order.getOrderHeader().getOrderID(), order.getOrderHeader().getOrderDate(),
                                order.getOrderHeader().getName(), order.getFlowerCount(), order.getTotalFlowerCost());
                        System.out.println("-----------------------------------------------------------------------------------");
                    }
                }

                if (sortedField.equalsIgnoreCase("name") && sortOrder.equalsIgnoreCase("ASC")) {
                    sortByNamewithASC(orders);

                    for (Order order : this) {

                        System.out.printf("| %5s | %-9s | %11s | %-15s | %-10s | %12s | \n", orders1.indexOf(orders) + 1,
                                order.getOrderHeader().getOrderID(), order.getOrderHeader().getOrderDate(),
                                order.getOrderHeader().getName(), order.getFlowerCount(), order.getTotalFlowerCost());
                        System.out.println("-----------------------------------------------------------------------------------");
                    }
                }

                if (sortedField.equalsIgnoreCase("name") && sortOrder.equalsIgnoreCase("DESC")) {
                    sortByNamewithDESC(orders);

                    for (Order order : this) {

                        System.out.printf("| %5s | %-9s | %11s | %-15s | %-10s | %12s | \n", orders1.indexOf(orders) + 1,
                                order.getOrderHeader().getOrderID(), order.getOrderHeader().getOrderDate(),
                                order.getOrderHeader().getName(), order.getFlowerCount(), order.getTotalFlowerCost());
                        System.out.println("-----------------------------------------------------------------------------------");
                    }
                }

            }
        }
    }

    private boolean existFlowerID(String flowerID, FlowerSet flowerSet) {
        for (Flower flower : flowerSet) {
            if (flower.getId().equalsIgnoreCase(flowerID)) {
                return true;
            }
        }
        return false;
    }

    private boolean existID(String orderID) {
        for (Order order : this) {
            if (order.getOrderHeader().getOrderID().equalsIgnoreCase(orderID)) {
                return true;
            }

        }
        return false;

    }
   

    private boolean existDetailID(String orderDetailID) {
        for (Order order : this) {
            if (order.getOrderDetail().containsKey(orderDetailID)) {
                return true;
            }
        }
        return false;
    }

    private void sortByIDwithASC(ArrayList<Order> orders) {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getOrderHeader().getOrderID().compareTo(o2.getOrderHeader().getOrderID());
            }
        };
        Collections.sort(orders, comparator);
    }

    private void sortByIDwithDESC(ArrayList<Order> orders) {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getOrderHeader().getOrderID().compareTo(o1.getOrderHeader().getOrderID());
            }
        };
        Collections.sort(orders, comparator);
    }

    private void sortByDatewithASC(ArrayList<Order> orders) {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getOrderHeader().getOrderDate().compareTo(o2.getOrderHeader().getOrderDate());
            }
        };
        Collections.sort(orders, comparator);
    }

    private void sortByDatewithDESC(ArrayList<Order> orders) {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getOrderHeader().getOrderDate().compareTo(o1.getOrderHeader().getOrderDate());
            }
        };
        Collections.sort(orders, comparator);
    }

    private void sortByNamewithASC(ArrayList<Order> orders) {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getOrderHeader().getName().compareTo(o2.getOrderHeader().getName());
            }
        };
        Collections.sort(orders, comparator);
    }

    private void sortByNamewithDESC(ArrayList<Order> orders) {
        Comparator<Order> comparator = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getOrderHeader().getName().compareTo(o1.getOrderHeader().getName());
            }
        };
        Collections.sort(orders, comparator);
    }

    public void saveOder() {

        try {
            File file = new File("src\\output\\orders.dat"); //The binary file
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Order order : this) {
                oos.writeObject(order);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Failed to save. Error writing file.");
        }
    }

    public OrderSet loadData(OrderSet orderSet) throws IOException {

        File file = new File("src\\output\\orders.dat"); //The binary file

        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
            boolean isFinish = false;
            do {

                try {

                    Object ob = ois.readObject();
                    if (ob instanceof Order) {
                        Order order = (Order) ob;
                        orderSet.add(order);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    isFinish = true;
                }
            } while (!isFinish);

            System.out.println("Loaded order data!");
        } catch (Exception e) {
            System.out.println("Failed to load. Error reading file.");
        }
        return orderSet;
    }

}
