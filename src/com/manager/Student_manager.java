package com.manager;


import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * com.manager
 * Create by Le Nguyen Tu Van
 * Date 10/31/2021 - 8:17 PM
 * Description: ...
 */
public class Student_manager {

    public static void main(String[] args) throws InterruptedException, IOException {

        Student_manager console = new Student_manager();
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            int choice;
            System.out.println("-----Student Management Program-----");
            System.out.println("1. Add a student");
            System.out.println("2. Update student information");
            System.out.println("3. Delete a student");
            System.out.println("4. View student list with the student id in ascending order");
            System.out.println("5. View student list with the GPA in ascending order");
            System.out.println("6. Save student list into file");
            System.out.println("7. Export student list to text file (csv)");
            System.out.println("8. Import student list from text file (csv)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scn.nextInt();
            if (choice == 0) break;
            if (choice == 1) console.add();
            if (choice == 2) console.update();
            if (choice == 3) console.delete();
            if (choice == 4) console.viewIdAscending();
            if (choice == 5) console.viewGPAAscending();
            if (choice == 6) console.saveMethod();
            if (choice == 7) console.saveMethod();
            if (choice == 8) console.importMethod();

        }
    }

    private StudentList studentList;

    /**
     * Default constructor
     */
    public Student_manager() {
        studentList = new StudentList();
    }

    /**
     * Constructor
     * @param studentList student list
     */
    public Student_manager(StudentList studentList) {
        this.studentList = studentList;
    }

    /**
     * Copy constructor
     * @param std student manager
     */
    public Student_manager(Student_manager std) {
        this.studentList = std.studentList;
    }

    /**
     * Add a student
     */
    public void add() throws InterruptedException {

        Scanner scn = new Scanner(System.in);
        String id, name, img, address, note;
        double gpa;

        System.out.println("\nEnter student information: ");
        System.out.print("Id: ");
        id = scn.nextLine();
        System.out.print("Name: ");
        name = scn.nextLine();
        System.out.print("GPA: ");
        gpa = scn.nextDouble();
        scn.nextLine();
        System.out.print("Image link: ");
        img = scn.nextLine();
        System.out.print("Address: ");
        address = scn.nextLine();
        System.out.print("Note: ");
        note = scn.nextLine();

        Student newStudent = new Student(id, name, gpa, img, address, note);
        studentList.addStudent(newStudent);
        System.out.println("Done!");
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Update a student with id
     */
    public void update() throws InterruptedException {
        if (studentList.size() == 0) {
            System.out.println("\nThe list is empty!");
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
            return;
        }
        Scanner scn = new Scanner(System.in);
        String id, name, img, address, note;
        double gpa;

        System.out.print("\nEnter student id you want to update: ");
        String newId = scn.nextLine();
        if(!studentList.checkContain(newId)){
            System.out.println("Does not have that id!");
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
            return;
        }

        System.out.println("\nEnter student information for update: ");
        System.out.print("Name: ");
        name = scn.nextLine();
        System.out.print("GPA: ");
        gpa = scn.nextDouble();
        scn.nextLine();
        System.out.print("Image link: ");
        img = scn.nextLine();
        System.out.print("Address: ");
        address = scn.nextLine();
        System.out.print("Note: ");
        note = scn.nextLine();
        Student newStudent = new Student(newId, name, gpa, img, address, note);
        studentList.updateStudent(newId, newStudent);
        System.out.println("Done!");
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Delete a student
     */
    public void delete() throws InterruptedException {
        if (studentList.size() == 0) {
            System.out.println("\nThe list is empty!");
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
        }
        else {
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter student id you want to delete: ");
            String id = scn.nextLine();

            if(!studentList.checkContain(id)){
                System.out.println("Does not have that id!");
                System.out.println();
                TimeUnit.SECONDS.sleep(1);
                return;
            }

            studentList.removeStudent(id);
            System.out.println("Done!");
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    /**
     * View student list with the student id in ascending order
     */
    public void viewIdAscending() throws InterruptedException {
        if (studentList.size() == 0) {
            System.out.println("The list is empty! Please add a student or import from a file");
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
        }
        else {
            studentList.ascendingById();
            studentList.view();
        }
    }

    /**
     * View student list with the student GPA in ascending order
     */
    public void viewGPAAscending() throws InterruptedException {
        if (studentList.size() == 0) {
            System.out.println("The list is empty! Please add a student or import from a file");
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
        }
        else {
            studentList.ascendingByGPA();
            studentList.view();
        }
    }

    /**
     * Save student list to a file
     * @param filename file name (String)
     */
    public void saveIntoFile(String filename) throws IOException {
        FileWriter fout;

        try {
            fout = new FileWriter(filename);
        } catch (IOException exc) {
            System.out.println("File error!");
            return;
        }
        String str = "Id,Name,GPA,Image,Address,Note\n";
        fout.write(str);
        fout.write(studentList.toString());
        fout.close();
    }

    /**
     * Save method
     */
    public void saveMethod() throws IOException, InterruptedException {
        Scanner scn = new Scanner(System.in);
        String filename;

        System.out.print("\nEnter filename: ");
        filename = scn.nextLine();
        saveIntoFile(filename);

        System.out.println("Saved to " + filename + "!");
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Import student information from a file
     * @param filename file name (String)
     */
    public void importFromFile(String filename) throws IOException {
        BufferedReader fin;
        String line;
        String id, name, image, address, note;
        double gpa;
        try {
            fin = new BufferedReader(new FileReader(filename));

        } catch (FileNotFoundException exc) {
            System.out.println("File not found!");
            return;
        }
        line = fin.readLine();
        while ((line = fin.readLine()) != null) {
            String[] str = line.split(",");
            id = str[0];
            name = str[1];
            gpa = Double.parseDouble(str[2]);
            image = str[3];
            address = str[4];
            note = str[5];
            Student newStudent = new Student(id, name, gpa, image, address, note);
            studentList.addStudent(newStudent);
        }
        fin.close();
    }

    /**
     * Save method
     */
    public void importMethod() throws InterruptedException, IOException {
        Scanner scn = new Scanner(System.in);
        String filename;

        System.out.print("\nEnter filename: ");
        filename = scn.nextLine();
        importFromFile(filename);

        System.out.println("Imported!");
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }
}
