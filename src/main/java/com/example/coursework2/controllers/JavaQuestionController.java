package com.example.coursework2.controllers;

import com.example.coursework2.models.Question;
import com.example.coursework2.services.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(questionService.add(question, answer));
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.remove(questionService.add(question, answer));
    }

    @GetMapping("/")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}
