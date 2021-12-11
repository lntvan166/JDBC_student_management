package com.manager;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * com.manager
 * Create by Le Nguyen Tu Van
 * Date 10/31/2021 - 8:29 PM
 * Description: ...
 */
public class StudentList {
    public static void main(String[] args) {

    }

    private List<Student> list;

    /**
     * Default constructor
     */
    public StudentList() {
        list = new ArrayList<Student>();
    }

    /**
     * Constructor
     * @param list student list (Student[])
     */
    public StudentList(List<Student> list) {
        this.list = list;
    }

    /**
     * Constructor from array
     * @param list student list (Student[])
     */
    public StudentList(Student[] list) {
        this.list = List.of(list);
    }

    /**
     * Copy constructor
     * @param stlist student list (StudentList)
     */
    public StudentList(StudentList stlist) {
        this.list = stlist.list;
    }

    /**
     * Getter of list
     * @return student list
     */
    public List<Student> getList() {
        return list;
    }

    /**
     * Setter of list
     * @param list student list
     */
    public void setList(List<Student> list) {
        this.list = list;
    }

    public void view() throws InterruptedException {
        System.out.println("Student list: ");
        for(Student student : list) {
            System.out.println(student.toString());
        }
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }

    /**
     * Add a student
     * @param student Student
     */
    public void addStudent(Student student) {
        list.add(student);
    }

    /**
     * Update a student
     * @param id id student want to update
     * @param student new info of student
     */
    public void updateStudent(String id, Student student) {
        for(Student std : list) {
            if(Objects.equals(id, std.getId())){
               std.update(student);
                break;
            }
        }
    }

    public boolean checkContain(String id) {
        boolean isContain = false;
        for(Student std : list) {
            if(Objects.equals(id, std.getId())){
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    /**
     * Remove a student
     * @param id student id (String)
     */
    public void removeStudent(String id) {
        for(int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), id))
                list.remove(i);
        }
    }

    /**
     * Sort ascending by id
     */
    public void ascendingById() {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
    }

    /**
     * Sort ascending by gpa
     */
    public void ascendingByGPA() {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getGpa(), o2.getGpa());
            }
        });
    }

    /**
     * size of student list
     * @return size (int)
     */
    public  int size() {
        return list.size();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Student std: list) {
            str.append(std.toString());
            str.append("\n");
        }
        return str.toString();
    }

    public Student findById(String id) {
        Student result = null;
        for(Student std : list) {
            if (Objects.equals(std.getId(), id)){
                result = std;
                break;
            }
        }

        return result;
    }

    public boolean checkIdExist(String id) {
        boolean result = false;
        for(Student std : list) {
            if (Objects.equals(std.getId(), id)){
                result = true;
                break;
            }
        }

        return result;
    }

    public String[] idList() {
        List<String> result = new ArrayList<String>();
        for(Student std : list) {
            result.add(std.getId());
        }

        return result.toArray(new String[0]);
    }
}

