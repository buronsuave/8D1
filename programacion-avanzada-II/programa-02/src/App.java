/**
 * @author: David Alejandro Lopez Torres. 17300155. 8D1
 * @version: 1.0
 */

import java.io.PrintStream;
import java.util.Scanner;

import math.objects.Matrix;
import operations.StaticMath;

public class App {
    private static PrintStream console = System.out;
    private static Scanner reader = new Scanner(System.in);

    /**      
     * Make operations with matrix. Contains menu
     * @param args - default arguments
     * @throws Exception all program exceptions
     */
    public static void main(String[] args) throws Exception {
        boolean flag = true;
        do {
            console.println("Select an option: ");
            console.println("1: Add");
            console.println("2: Subb");
            console.println("3: Prod");
            console.println("4: Trans");
            console.println("5: Exit");

            String op = reader.nextLine();        
            switch (op) {
                // Add matrixes
                case "1" : {
                    console.println("Read Matrix A: ");
                    Matrix A = readMatrix();
                    console.println("-------------------");
                    console.println("Matrix A: ");
                    console.println(A);
                    console.println("-------------------");

                    console.println("Read Matrix B: ");
                    Matrix B = readMatrix();
                    console.println("-------------------");
                    console.println("Matrix B: ");
                    console.println(B);
                    console.println("-------------------");

                    if (A.getCols() != B.getCols() || A.getRows() != B.getRows()) {
                        console.println("Dimensions do not match. Try again");
                        break;
                    }

                    console.println("-------------------");
                    console.println("Matrix A+B: ");
                    Matrix C = StaticMath.addMatrix(A, B);
                    console.println(C);
                    console.println("-------------------");
                break;
                }
                
                // Subb matrixes
                case "2" : {
                    console.println("Read Matrix A: ");
                    Matrix A = readMatrix();
                    console.println("-------------------");
                    console.println("Matrix A: ");
                    console.println(A);
                    console.println("-------------------");

                    console.println("Read Matrix B: ");
                    Matrix B = readMatrix();
                    console.println("-------------------");
                    console.println("Matrix B: ");
                    console.println(B);
                    console.println("-------------------");

                    if (A.getCols() != B.getCols() || A.getRows() != B.getRows()) {
                        console.println("Dimensions do not match. Try again");
                        break;
                    }

                    console.println("-------------------");
                    console.println("Matrix A-B: ");
                    Matrix C = StaticMath.subbMatrix(A, B);
                    console.println(C);
                    console.println("-------------------");
                break;
                }

                // Cross matrixes
                case "3" : {
                    console.println("Read Matrix A: ");
                    Matrix A = readMatrix();
                    console.println("-------------------");
                    console.println("Matrix A: ");
                    console.println(A);
                    console.println("-------------------");

                    console.println("Read Matrix B: ");
                    Matrix B = readMatrix();
                    console.println("-------------------");
                    console.println("Matrix B: ");
                    console.println(B);
                    console.println("-------------------");

                    if (A.getCols() != B.getRows()) {
                        console.println("Dimensions do not match (A.cols must be equal to B.rows). Try again");
                        break;
                    }

                    console.println("-------------------");
                    console.println("Matrix A X B: ");
                    Matrix C = StaticMath.crossMatrix(A, B);
                    console.println(C);
                    console.println("-------------------");
                break;
                }

                // Transpose matrix
                case "4" : {
                    console.println("Read Matrix: ");
                    Matrix A = readMatrix();
                    console.println("-------------------");
                    console.println("Matrix: ");
                    console.println(A);
                    console.println("-------------------");

                    console.println("-------------------");
                    console.println("Trans Matrix: ");
                    Matrix B = StaticMath.transMatrix(A);
                    console.println(B);
                    console.println("-------------------");
                }
                break;
                case "5" :
                    console.println("Bye");
                    flag = false;
                break;
                default:
                    console.println("Invalid option. Try again");
            }

        } while (flag);
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

    /**
     * Reads a new matrix. Has validations
     * @return new Matrix object
     */
    public static Matrix readMatrix() {
        console.print("Set rows: ");
        int rows = 0;
        do {
            rows = readInt();
            if (rows < 1) {
                console.println("Rows must be at least 1");
            }
        } while(rows < 1);

        console.print("Set cols: ");
        int cols = 0;
        do {
            cols = readInt();
            if (cols < 1) {
                console.println("Cols must be at least 1");
            }
        } while(cols < 1);

        int[][] values = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                console.println("Set value["+i+"]"+"["+j+"]");
                values[i][j] = readInt();
            }
        }

        return new Matrix(values);
    }
}
