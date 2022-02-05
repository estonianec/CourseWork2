package com.example.coursework2.services.impl;

import com.example.coursework2.models.Question;
import com.example.coursework2.services.ExaminerService;
import com.example.coursework2.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private final Set<Question> questions = new HashSet<>();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IllegalArgumentException();
        }
        questions.clear();
        do {
            questions.add(questionService.getRandomQuestion());
        } while (questions.size() != amount);
        return questions;
    }
}
