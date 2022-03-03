package org.example.service;

import org.example.domain.Student;

import java.util.List;

public interface StudentService {

    Integer service_addStudent(Student student);
    List<Student> service_selectStudent();

}
