package com.example.coursework2.controllers;

import com.example.coursework2.models.Question;
import com.example.coursework2.services.ExaminerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController{

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @RequestMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
