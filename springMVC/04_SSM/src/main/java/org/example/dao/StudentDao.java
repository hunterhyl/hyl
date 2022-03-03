package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {
    public Integer addStudent(Student student);

    public List<Student> selectStudents();

}
