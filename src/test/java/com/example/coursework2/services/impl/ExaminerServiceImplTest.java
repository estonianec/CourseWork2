package com.example.coursework2.services.impl;

import com.example.coursework2.models.Question;
import com.example.coursework2.services.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    void getQuestionsTest() {
        Set<Question> questions = new HashSet<>();
        when(questionServiceMock.getRandomQuestion()).thenReturn(new Question("FIRST QUESTION", "FIRST ANSWER"), new Question("SECOND QUESTION", "SECOND ANSWER"), new Question("THIRD QUESTION", "THIRD ANSWER"));
        when(questionServiceMock.getAll()).thenReturn(questions);
        questions.add(new Question("FIRST QUESTION", "FIRST ANSWER"));
        questions.add(new Question("SECOND QUESTION", "SECOND ANSWER"));
        questions.add(new Question("THIRD QUESTION", "THIRD ANSWER"));
        assertTrue(out.getQuestions(3).containsAll(questions));
    }

    @Test
    void getNegativeNumericQuestions() {
        assertThrows(IllegalArgumentException.class, () -> out.getQuestions(-1));
    }

    @Test
    void getMoreThanExistsQuestions() {
        assertThrows(IllegalArgumentException.class, () -> out.getQuestions(2));
    }

}