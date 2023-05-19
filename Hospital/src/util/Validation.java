
package util;

import java.time.LocalDate;
import java.util.Scanner;

public class Validation {
    private static final Scanner sc =  new Scanner(System.in);
    
    
    //check the input don't null;
    public static String checkString(String mess) {
        String value;
        while (true) {       
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if(value.isEmpty()) {
                    throw new Exception("Please input value!");
                }
                return value;
            } catch (Exception e) {
            }
        }     
            
    }
    
    //check the number bigger than 0. Use it to check the Age.
    public static int checkInt(String mess) {
        int value;
        while (true) {            
            try {
                System.out.print(mess);
                value = sc.nextInt();
                if(value <= 0) {
                    throw new Exception("It must be bigger than 0");
                }
               
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a number");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Check the Double value bigger than 0, use it to check the Salary.
    public static double checkDouble(String mess) {
        double value;
        while (true) {
            try {
                System.out.print(mess);
                value = sc.nextDouble();
                if(value < 0) {
                    throw new Exception("It must be bigger than 0");
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    // Check the length of String value, use it to check the Department.
    public static String checkStringLength(String mess) {
        String value;
        while (true) {      
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if(value.length() < 3 || value.length() > 50) {
                    throw new Exception("The length must be from 3 to 50 characters");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }                 
    }
    
   /* //Check the String value with have 10 numbers. Use it to check the phone number.
    public static String checkPhone(String mess) {
        String value;
        while (true) {            
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if(value.length() != 10) {
                    throw new Exception("A phone number must have 10 numbers");
                }
                if(!value.matches("\\d+")) {
                    throw new Exception("The phone number must contain only digits");
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String checkPhone(String mess) {
        String value;
        while(true) {
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if(value.length() != 10) {
                    throw new Exception("A phone must have 10 number");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("The phone only contain digits");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
*/
    // Check the date format. The right format is yyyy-MM-dd
    public static String checkDate(String mess) {
        String value;
        
        while (true) {            
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if(!isValidDateFormat(value)) {
                    throw new Exception("The date format must be yyyy-MM-dd");
                }
            } catch (Exception e) {
            }
        }
    }
    
    public static boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean confirmYesOrNo(String mess) {
        String value;
        System.out.print(mess);
        value = sc.nextLine();
        if(value == null) {
            System.out.println("Please enter something!");
             
        }
        return value.equalsIgnoreCase("Y");
        
    }
    
    
}
