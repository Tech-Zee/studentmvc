/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.student.controller;

import com.student.model.Student;
import com.student.repository.StudentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Display home page
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("student", new Student());

        return "home";
    }

    // Save student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {

        studentRepository.save(student);

        return "redirect:/";
    }
}
