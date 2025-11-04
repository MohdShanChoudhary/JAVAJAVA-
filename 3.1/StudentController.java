package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}
