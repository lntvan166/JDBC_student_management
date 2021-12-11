package com.manager;

/**
 * vn.edu.fitus.clc.lntvan19
 * Create by Le Nguyen Tu Van
 * Date 10/31/2021 - 8:17 PM
 * Description: ...
 */
public class Student {
    public static void main(String[] args) {

    }

    private String id;
    private String name;
    private float gpa;
    private String img;
    private String address;
    private String note;

    /**
     * Default constructor
     */
    public Student() {
        id = "";
        name = "";
        gpa = 0.0F;
        img = "";
        address = "";
        note = "";
    }

    /**
     * Constructor
     * @param id student id
     * @param name student name
     * @param gpa grade point average
     * @param img image link
     * @param address student address
     * @param note note
     */
    public Student(String id, String name, float gpa, String img, String address, String note) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.img = img;
        this.address = address;
        this.note = note;
    }

    /**
     * Copy constructor
     * @param student student
     */
    public Student(Student student) {
        this.id = student.id;
        this.name = student.name;
        this.gpa = student.gpa;
        this.img = student.img;
        this.address = student.address;
        this.note = student.note;
    }

    /**
     * Getter of student id
     * @return id (String)
     */
    public String getId() {
        return id;
    }

    /**
     * Setter of student id
     * @param id id (String)
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter of student name
     * @return name (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of student name
     * @param name name (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of student gpa
     * @return gpa (double)
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Setter of student gpa
     * @param gpa gpa (double)
     */
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    /**
     * Getter of student image link
     * @return image link (String)
     */
    public String getImg() {
        return img;
    }

    /**
     * Setter of student image link
     * @param img image link (String)
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Getter of student address
     * @return address (String)
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter of student address
     * @param address address (String)
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter of student note
     * @return note (String)
     */
    public String getNote() {
        return note;
    }

    /**
     * Setter of student note
     * @param note note (String)
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Update student information
     * @param student new student (Student)
     */
    public void update(Student student) {
        this.id = student.id;
        this.name = student.name;
        this.gpa = student.gpa;
        this.img = student.img;
        this.address = student.address;
        this.note = student.note;
    }

    /**
     * To string
     * @return String
     */
    public String toString() {
        String str;
        str = id + "," + name + "," + gpa + "," + img + "," + address + "," + note;
        return str;
    }


}
