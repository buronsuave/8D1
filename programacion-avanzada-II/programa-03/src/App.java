/**
 * @author: David Alejandro Lopez Torres. 17300155. 8D1
 * @version: 1.0
 */


import java.io.PrintStream;
import java.util.Scanner;

import sorts.Sorter;

public class App {
    private static PrintStream console = System.out;
    private static Scanner reader = new Scanner(System.in);

    /**
     * Reads an array and use radix sort to sort it
     * @param args - default configuration
     * @throws Exception all program exceptions
     */
    public static void main(String[] args) throws Exception {
        
        boolean flag = true;
        do {
            console.println("Type the count of elements: ");
            int count = 0;
            do {
                count = readInt();
                if (count < 1) {
                    console.println("The count must be at least one");
                }
            } while(count < 1);   

            int[] unsorted = readArray(count);
            console.println("Unsorted Array: ");
            console.println(arrayToString(unsorted));

            int[] sorted = Sorter.radixSort(unsorted);
            console.println("Sorted Array: ");
            console.println(arrayToString(sorted));

            console.println("Press 1 to make another try. 0 to quit");
            flag = (readInt() == 1);
            
        } while (flag);

        console.println("Bye");
    }

    /**
     * Creates an string to represent an array
     * @param array - array to represent
     * @return string of the array
     */
    public static String arrayToString(int[] array) {
        String outString = "";
        for (int i = 0; i < array.length; i++) {
            outString += array[i];
            if (i < array.length - 1) {
                outString += ", ";
            }
        }

        return outString;
    }

    /**
     * Creates an array for a given lecture
     * @param count - number of elements of the array
     * @return new int array of count elements
     */
    public static int[] readArray(int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            console.println("Read value " + (i+1));
            do {
                array[i] = readInt();
                if (array[i] < 0) {
                    console.println("The count must be positive");
                }
            } while (array[i] < 0);
        }
        return array;
    }
    
    /**
     * Read an integer from scanner
     * @return int on input
     */
    public static int readInt() {
        boolean flag = true;
        int number = 0;
        do {
            try {
                String string = reader.nextLine();
                number = Integer.parseInt(string);
                flag = false;
            } catch (NumberFormatException e) {
                console.println("Not an integer. Try again");
            }
            
        } while (flag);

        return number;
    }
}
