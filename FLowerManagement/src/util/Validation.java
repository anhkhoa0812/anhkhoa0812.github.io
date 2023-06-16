package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static String checkString(String mess) {
        String value = "";

        do {
            try {
                System.out.print(mess + "");
                value = sc.nextLine();

                if (value.isEmpty()) {
                    throw new Exception("This value must not be null");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (value.isEmpty());
        return value;
    }


    public static int checkInt(String mess) {
        int value = 0;
        do {
            try {
                System.out.print(mess + "");
                value = Integer.parseInt(sc.nextLine());

                if (value <= 0) {
                    throw new Exception("This value must be positive.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("This value must be digits");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (value <= 0);
        return value;
    }

    public static String checkStringLength(String mess) {
        String value = "";
        do {

            try {
                System.out.print(mess + "");
                value = sc.nextLine();

                if (value.length() < 3) {
                    throw new Exception("The value must be from 3 characters!");
                }

                if (value.length() > 50) {
                    throw new Exception("The value must not be exceed 50 characters!");
                }

                if (value.isEmpty()) {
                    throw new Exception("The value must not be null!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (value.length() < 3 || value.length() > 50 || value.isEmpty());
        return value;
    }

    public static double checkDouble(String mess) {
        double value = 0;

        do {

            try {
                System.out.print(mess + "");
                value = Double.parseDouble(sc.nextLine());

                if (value <= 0) {
                    throw new Exception("The value must not be null");
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("The value must be digits");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } while (value <= 0);
        return value;
    }

    /**
     * Checks if the input string represents a valid date which matches
     * {@linkplain  isValidDateFormat(java.lang.String)}.
     *
     * @param mess The message prompt for user input.
     * @return The string entered by user in a valid date format.
     */
    public static String checkDate(String mess) {
        String value = "";

        do {
            try {
                System.out.print(mess);
                value = sc.nextLine();
                if (!isValidDateFormat(value)) { //Check date format
                    throw new Exception("The date format must be dd/MM/yyyy");
                }

                if (value == null) { //Check null
                    throw new Exception("It cannot be null");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (value == null || !isValidDateFormat(value));

        return value;
    }

    /**
     * Checks if the input string represents a valid date in the format
     * "dd/MM/yyyy".
     *
     * @param date The string representing a date.
     * @return True if the input string is a valid date format in a specified
     * format, false otherwise.
     */
    public static boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //Date format
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
