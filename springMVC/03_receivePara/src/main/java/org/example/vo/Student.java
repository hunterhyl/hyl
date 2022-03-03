package org.example.vo;

public class Student {

    private String student_name;
    private Integer student_age;

    @Override
    public String toString() {
        return "Student{" +
                "student_name='" + student_name + '\'' +
                ", student_age=" + student_age +
                '}';
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    public Student() {
    }

    public Student(String student_name, Integer student_age) {
        this.student_name = student_name;
        this.student_age = student_age;
    }

    public Student(Integer student_age) {
        this.student_age = student_age;
    }
}
