 
package view;

import java.util.Date;

public class Menu {
    public static void showDisplayOrdersMenu(Date startDate, Date endDate) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("| %5s | %-9s | %11s | %-15s | %-10s | %12s | \n", "No.", 
                "Order ID", "Order Date", "Customer", "Flower Count", "Order Total");
        System.out.println("-----------------------------------------------------------------------------------");
    }
         
    public static void storelMenu(Object[] options) {
        int choice = 0;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|                          FLOWER STORE                         |");
        System.out.println("-----------------------------------------------------------------");
        printChoice(options);
        System.out.println("|                                                               |");
        System.out.println("-----------------------------------------------------------------");

    }

    private static void printChoice(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("| %2d. %-58s| \n", (i + 1), options[i]);
        }
    }
    
    public static void showSortMenu(String sortedField, String sortOrder) {
        System.out.println("LIST OF ORDERS\n");
        System.out.println("Sort by: " + sortedField);
        System.out.println("Sort order: " + sortOrder);
        System.out.println("");
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("| %5s | %-9s | %11s | %-15s | %-10s | %12s | \n", "No.", 
                "Order ID", "Order Date", "Customer", "Flower Count", "Order Total");
        System.out.println("-----------------------------------------------------------------------------------");
        
    }
    
    public static void updateFlowerMenu() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|                            Update options                             |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s |\n", "1.Description", "2.Import Date", "3.Unit Price", "4.Category");
        System.out.println("-------------------------------------------------------------------------");
    }
}
