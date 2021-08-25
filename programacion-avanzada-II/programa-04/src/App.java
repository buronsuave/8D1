/**
 * @author: David Alejandro Lopez Torres
 * @version: 1.0
 */

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import pojos.Student;
import utils.List;

public class App {
    private static final PrintStream console = System.out;
    public static final Scanner reader = new Scanner(System.in);
    private static List list = new List();

    /**
     * Single CRUD Application using POJO Student and custom List class
     * @param args - default program configuration
     * @throws Exception all program exceptions
     */
    public static void main(String[] args) throws Exception {
        boolean flag = true;
        do {
            console.println("\n-------------------------------");
            console.println("Select an option: ");
            console.println("1: View students");
            console.println("2: View student");
            console.println("3: Add student");
            console.println("4: Update student");
            console.println("5: Delete student");
            console.println("6: Exit");
            console.println("-------------------------------\n");

            String op = reader.nextLine();
            switch(op) {

                // View students
                case "1": {
                    if (list.getCount() == 0) {
                        console.println("There are any students yet");
                    } else {
                        console.println(list);
                    }
                    break;
                }

                // View student
                case "2": {
                    if (list.getCount() == 0) {
                        console.println("There are not any students yet");
                    } else {
                        console.print("Enter id: ");
                        int id = readInt();
                        Student student = list.search(id);
                        if (student == null) {
                            console.println("Student was not found");
                        } else {
                            console.println(student);
                        }
                    }
                    break;
                }

                // Add
                case "3": {
                    console.print("Enter id: ");
                    int id;
                    do {
                        id = readInt();
                        Student student = list.search(id);
                        if (id < 1) {
                            console.println("id must be at least 1");
                        }
                        else if (student != null) {
                            console.println("The given id already exists. Try again");
                            id = -1;
                        }
                    } while (id < 1);

                    console.print("Enter name: ");
                    String name = reader.nextLine();

                    console.print("Enter last name: ");
                    String lastName = reader.nextLine();

                    boolean dateFlag = true;
                    String dateString = "";
                    LocalDate birthDate = LocalDate.of(2000, 1, 1);
                    console.print("Enter birth date (year-month-day, using numbers): ");
                    do {
                        dateString = reader.nextLine();
                        try {
                            birthDate = LocalDate.parse(dateString); 
                            dateFlag = false;                        
                        } catch (Exception e) {
                            console.println("Invalid format. Try again");
                        }
                    } while (dateFlag);

                    Student student = new Student(id, name, lastName, birthDate);
                    if (list.add(student)) {
                        console.print("User has been added ok");
                    } else {
                        console.print("Something went wrong. Try again");
                    }
                    break;
                }

                // Update
                case "4": {
                    console.print("Enter id: ");
                    int id = readInt();
                    Student student = list.search(id);
                    if (student == null) {
                        console.println("The id was not found. Try again");
                        break;
                    }

                    String name = null;
                    String lastName = null;
                    LocalDate birthDate = null;

                    console.print("Update name? 1:Yes, Other:No ");
                    int selection  = readInt();
                    if (selection == 1) {
                        console.print("Enter name: ");
                        name = reader.nextLine();
                    }

                    console.print("Update last name? 1:Yes, Other:No ");
                    selection  = readInt();
                    if (selection == 1) {
                        console.print("Enter last name: ");
                        lastName = reader.nextLine();
                    }

                    console.print("Update birth date? 1:Yes, Other:No ");
                    selection  = readInt();
                    if (selection == 1) {
                        console.print("Enter birth date: ");
                        boolean dateFlag = true;
                        do {
                            String dateString = reader.nextLine();
                            try {
                                birthDate = LocalDate.parse(dateString); 
                                dateFlag = false;  
                            } catch (Exception e) {
                                console.println("Invalid format. Try again");
                            }
                        } while (dateFlag);
                    }

                    if (list.update(id, name, lastName, birthDate)) {
                        console.println("User has been updated ok");
                    } else {
                        console.println("Something went wrong. Try again");
                    }
                    break;
                }

                // Delete
                case "5": {
                    console.println("Enter id: ");
                    int id = readInt();
                    if (list.delete(id)) {
                        console.println("User has been deleated ok");
                    } else {
                        console.println("Could not find the user. Try again");
                    }
                    break;
                }

                // Exit
                case "6": {
                    console.println("Bye");
                    flag = false;
                    break;
                }

                // Default
                default: {
                    console.println("Invalid option. Try again");
                    break;
                }
            
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
}
