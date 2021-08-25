package pojos;

/**
 * @author: David Alejandro Lopez Torres
 * @version: 1.0
 */

import java.time.LocalDate;

public class Student {

    // Properties
    private int id;
    private String name;
    private String lastName;
    private LocalDate birthDate;

    // Constructors
    public Student() {
        this.id = -1;
        this.name = "No Name";
        this.lastName = "No Lastname";
        this.birthDate = LocalDate.of(2000, 1, 1);
    }

    public Student(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.birthDate = student.getBirthDate();
    }

    public Student(int id, String name, String lastName, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    
    // Getters and Setters

    public int getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String outString = "";
        
            outString += "id: ";
            outString += id;
            outString += "; ";
            outString += "Name: ";
            outString += name;
            outString += "; ";
            outString += "Last Name: ";
            outString += lastName;
            outString += "; ";
            outString += "Birth Date: ";
            outString += birthDate.getDayOfMonth() + "-" + birthDate.getMonth() + "-" + birthDate.getYear();

        return outString;
    }
}
