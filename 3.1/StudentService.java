package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student student) {
        Student existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(student.getName());
            existing.setCourse(student.getCourse());
            return repo.save(existing);
        }
        return null;
    }

    public String deleteStudent(int id) {
        repo.deleteById(id);
        return "Student removed with ID: " + id;
    }
}
