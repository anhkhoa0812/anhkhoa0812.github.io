/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.FlowerSet;
import business.OrderSet;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import util.Validation;

/**
 *
 * @author tahoa
 */
public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        Scanner sc = new Scanner(System.in);

        FlowerSet flowerSet = new FlowerSet();
        OrderSet orderSet = new OrderSet();

        int choice;
        do {
            //Options of the menu.
            String[] hospitalOptions = {"Add a flower", "Find a flower", "Update a flower",
                "Delete a flower", "Add an orders", "Display orders", "Sort orders", "Save data", "Load data", "Quit"};
            Menu.storelMenu(hospitalOptions);
            choice = Validation.checkInt("Enter your choice(1->10):");

            switch (choice) {

                case 1: // Create nurse
                    String continueCheck;
                    do {
                        flowerSet.addFlower();
                        continueCheck = Validation.checkString("Do you want to continue add Flower? (Y/n): "); //Check continue

                    } while (continueCheck.equalsIgnoreCase("Y"));
                    System.out.println("\n");
                    break;

                case 2: // Find nurse
                    flowerSet.findFlower();
                    System.out.println("\n");
                    break;
                case 3: //Update nurse
                    flowerSet.updateFlower();
                    System.out.println("\n");
                    break;
                case 4: //Delete nurse
                    flowerSet.deleteFLower(orderSet);
                    System.out.println("\n");
                    break;
                case 5:
                    orderSet.addOrder(orderSet, flowerSet);
                    System.out.println("\n");
                    break;
                case 6:
                    orderSet.displayOrders();
                    System.out.println("\n");
                    break;
                case 7:
                    orderSet.sortOrders();
                    System.out.println("\n");
                    break;
                case 8:
                    flowerSet.saveFlower(flowerSet);
                    orderSet.saveOder();
                    break;
                case 9:
                    flowerSet.loadData(flowerSet);
                    orderSet.loadData(orderSet);
                    break;
                case 10:
                    String quitCheck;
                    do {
                        quitCheck = Validation.checkString("Do you want to quit? (Y/N): "); //Confirm check.
                        if (quitCheck.equalsIgnoreCase("Y")) {
                            flowerSet.saveFlower(flowerSet);
                            orderSet.saveOder();

                            System.out.println("---GOODBYE---");
                            System.exit(0);
                        } else {
                            System.out.println("\n");
                        }

                    } while (quitCheck.equalsIgnoreCase("Y"));

                    break;
               

            }

        } while (choice >= 1 || choice <= 10);

    }
}
