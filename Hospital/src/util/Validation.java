
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The Validation class provides utility methods for validating user input.
 */
public class Validation {
    private static final Scanner sc =  new Scanner(System.in);
    
    
    /**
     * Check if the input string is  null or empty.
     * @param mess The message prompt for user input.
     * @return The non-empty string entered by the user.
     */
    public static String checkString(String mess) {
        String value;
       
        while (true) {
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if (value.isEmpty()) {
                    throw new Exception("Please input value!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }
    

    /**
     * Check if the input integer is greater than 0.
     * @param mess The message prompt for user input.
     * @return The positive integer entered by the user.
     */
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
    
    /**
     * Check if the input integer is greater than 0 and smaller than a specified maximum value.
     * @param mess The message prompt for user input.
     * @param max The maximum value allowed for the input user.
     * @return The integer entered by the user within a specified range.
     */
    public static int checkInt(String mess, int max) {
        int value;
        while (true) {            
            try {
                System.out.print(mess);
                value = sc.nextInt();
                if(value < 0) {
                    throw new Exception("Value must be bigger than 0");
                }
                if(value > max) {
                    throw new Exception("Value must be smaller than" + max);
                }
                return value;
            } catch(NumberFormatException ex) {
                System.out.println("Value must be only digits");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * Check if the input double is greater than 0.
     * @param mess The message prompt for user input.
     * @return The positive double entered by the user. 
     */
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
    
    /**
     * Checks if the length of the input string is between 3 and 50 characters.
     * @param mess The message prompt for user input.
     * @return The string entered by user with a valid length.
     */
    public static String checkStringLength(String mess) {
        String value;
        while (true) {      
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if(value.length() < 3 && value.length() > 50) {
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

    /**
     * Checks if the input string represents a valid date which matches isValidDateFormat(java.lang.String).
     * @param mess The message prompt for user input.
     * @return The string entered by user in a valid date format.
     * @see #isValidDateFormat(java.lang.String). 
     */
    public static String checkDate(String mess) {
        String value;
        
        while (true) {            
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if(!isValidDateFormat(value)) {
                    throw new Exception("The date format must be dd/MM/yyyy");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }
    
    /**
     * Checks if the input string represents a valid date in the format "dd/MM/yyyy".
     * @param date The string representing a date.
     * @return {@code true} if the input string is a valid date format in a specified format, {@code false} otherwise.
     */
    public static boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static String confirmYesOrNo(String mess) {
        String value;
        while (true) {            
            try {
                System.out.println(mess);
                value = sc.nextLine();
                if(value.isEmpty()) {
                    throw new Exception("Please enter a value!");
                }
                if (value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("N")) {
                    return value;
                }
                else
                    throw new Exception("Please input Y (=Yes) or N (=No)");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
    
    public static String[] checkNurseAssigned(String mess) throws Exception {
        String value;
        while (true) {            
            try {
                System.out.println(mess);

            } catch (Exception e) {
            }
        }
        
    }
    public static String checkPhone(String mess) {
        String value;
        String pattern = "{\\d{10}";
        Pattern phonePattern = Pattern.compile(pattern);
        while (true) {            
            try {
                System.out.println(mess);
                value = sc.nextLine();
                if(!(phonePattern.matcher(value).matches())) {
                    throw new Exception("A phone need 10 numbers");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    
    }
    
    

}
    

