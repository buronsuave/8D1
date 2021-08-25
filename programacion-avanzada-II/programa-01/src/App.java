/**
 * @author: David Alejandro Lopez Torres. 17300155. 8D1
 * @version: 1.0
 */

import java.io.PrintStream;
import java.util.Scanner;

import operations.*;

public class App {
    public static final int INT_FORMAT = 0;
    public static final int DOUBLE_FORMAT = 1;

    public static final Scanner reader = new Scanner(System.in);
    public static final PrintStream writer = System.out;

    /**
     * Program that checks number properties
     * @param args - default app configuration
     * @throws Exception any execution error 
     */
    public static void main(String[] args) throws Exception {
        boolean flag = true;

        do {
            writer.println("\n--------------------------------");
            writer.println("Select an operation");
            writer.println("1: Check prime number");
            writer.println("2: Check perfect number");
            writer.println("3: Calculate factorial");
            writer.println("4: Calculate square root");
            writer.println("5: Exit");
            writer.println("--------------------------------\n");

            

            String selection = reader.nextLine();
            switch (selection) {
                // Prime Number
                case "1": {
                    int value = (int) getNumber(INT_FORMAT);
                    writer.print(value);
                    boolean primeCheck = StaticMath.isPrime(value);
                    if (primeCheck) {
                        writer.println(" is a prime");
                    } else {
                        writer.println(" is not a prime");
                    }
                    break;
                }

                // Perfect Number
                case "2" : {
                    int value = (int) getNumber(INT_FORMAT);
                    writer.print(value);
                    boolean perfectCheck = StaticMath.isPerfect(value);
                    if (perfectCheck) {
                        writer.println(" is a perfect number");
                    } else {
                        writer.println(" is not a perfect number");
                    }
                    break;
                }

                // Factorial
                case "3" : {
                    int value = 1;
                    do {
                        if (value > 30) {
                            writer.println("The number must be in the range [0-30]");
                        }
                        value = (int) getNumber(INT_FORMAT);
                    } while (value > 30);
                    
                    writer.print(value);
                    double factorial = StaticMath.factorial(value);
                    writer.print("! = ");
                    writer.println(factorial);
                    break;
                }

                // Square Root
                case "4" : {
                    double value = getNumber(DOUBLE_FORMAT);
                    writer.print("The int part of square root of ");
                    writer.print(value);
                    int root = StaticMath.sqrt(value);
                    writer.print(" is ");
                    writer.println(root);
                    break;
                }
                case "5" : {
                    writer.println("\n--------------------------------");
                    writer.println("Bye");
                    writer.println("--------------------------------\n");
                    flag = false;
                }
                default: {
                    break;
                }
            }
        } while (flag);

        reader.close();
    }

    /**
     * Reads an scanned input and check if it's the expected format
     * @param format - int that express the format (with tags)
     * @return double with the readed value
     */
    public static double getNumber(int format) {
        boolean flag = true;
        double value = 1;

        switch (format) {
            case INT_FORMAT: {
                writer.println("Write a positive integer (like 1, 2, 16, ...)");        
                do {
                    try {
                        if (value < 0) {
                            writer.println("Only positive values. Try again");
                            value = 0;
                        }
                        value = Integer.parseInt(reader.nextLine());
                        flag = false;
                    } catch (NumberFormatException e) {
                        writer.println("Invalid input. Try again");
                        flag = true;                    
                    }
                } while (flag || value < 0);
                return value;                
            }

            case DOUBLE_FORMAT: {
                writer.println("Write a positive decimal number (like 1, 2.0, 5.62, ...)");        
                do {
                    try {
                        if (value < 0) {
                            writer.println("Only positive values. Try again");
                            value = 0;
                        }
                        value = Double.parseDouble(reader.nextLine());
                        flag = false;
                    } catch (NumberFormatException e) {
                        writer.println("Invalid input. Try again");
                        flag = true;                    
                    }
                } while (flag || value < 1);
                return value;
            }
        
            default: {
                return 0;
            }
        }
    }
}
