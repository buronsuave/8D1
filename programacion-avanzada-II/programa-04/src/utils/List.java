package utils;

/**
 * @author: David Alejandro Lopez Torres
 * @version: 1.0
 */

import java.time.LocalDate;

import pojos.Student;

public class List {
    // List values
    private Student[] data;

    // Constructor
    public List() {
        data = new Student[0];
    }

    /**
     * Push a new student into the list. Extends the array of data. 
     * Checks if the id is unique.
     * @param student - Student to push to the list
     * @return - boolean of status of operation
     */
    public boolean add(Student student) {
        Student curr = search(student.getId());
        if (curr != null) {
            return false;
        }

        Student[] aux = new Student[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            aux[i] = data[i];
        }
        aux[data.length] = student;

        data = aux;
        return true;
    }

    /**
     * Search for a given student by his id
     * @param id - int to query the student
     * @return student object if exists. Otherwise, return null 
     */
    public Student search(int id) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].getId() == id) {
                return data[i];
            }
        }

        return null;
    }

    /**
     * Update the values for a given student by his id
     * @param id - int to query the value for update
     * @param name - new name. null for no changes
     * @param lastName - new last name. null for no changes
     * @param birthDate - new birth date. null for no changes
     * @return boolean of status of operation
     */
    public boolean update(int id, String name, String lastName, LocalDate birthDate) {
        Student student = search(id);
        if (student != null) {
            if (name != null) {
                student.setName(name);
            }

            if (lastName != null) {
                student.setLastName(lastName);
            }

            if (birthDate != null) {
                student.setBirthDate(birthDate);
            }

            return true;
        }

        return false;
    }

    /**
     * Delete the student with a given id. Resize the array data
     * @param id - int to the student to delate
     * @return boolean of status of operation
     */
    public boolean delete(int id) {
        Student student = search(id);
        if (student != null) {
            
            Student[] aux = new Student[data.length - 1];
            int j = 0;

            for (int i = 0; i < data.length; i++) {
                if (data[i].getId() != id) {
                    aux[j] = data[i];
                    j++;
                }
            }

            data = aux;
            return true;
        }
        
        return false;
    }

    /**
     * Get the values on the list as an array
     * @return Student[] of the sudents
     */
    public Student[] getData() {
        return data;
    }

    /**
     * Set a given Student array to the data of list
     * @param data - Student[] to set on data
     */
    public void setData(Student[] data) {
        this.data = data;
    }

    /**
     * Get the count of therms in the data
     * @return int of the lenght of data
     */
    public int getCount() {
        return data.length;
    }

    @Override
    public String toString() {
        String outString = "";
        for (int i = 0; i < data.length; i++) {
            Student student = data[i];
            outString += student.toString();            
            outString += "\n";
        }
        return outString;
    }
}
