package com.example.coursework2.services.impl;

import com.example.coursework2.exceptions.QuestionAlreadyExistException;
import com.example.coursework2.exceptions.QuestionIsNotExistException;
import com.example.coursework2.models.Question;
import com.example.coursework2.services.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    void add() {
        Question result = out.add("FIRST QUESTION", "FIRST ANSWER");
        Question expected = new Question("FIRST QUESTION", "FIRST ANSWER");
        assertEquals(expected, result);
    }

    @Test
    void addLikeObject() {
        Question expected = new Question("FIRST QUESTION", "FIRST ANSWER");
        Question result = out.add(new Question("FIRST QUESTION", "FIRST ANSWER"));
        assertEquals(expected, result);
    }
    @Test
    void addTwiceQuestionLikeObject() {
        out.add(new Question("FIRST QUESTION", "FIRST ANSWER"));
        Assertions.assertThrows(QuestionAlreadyExistException.class,() -> out.add(new Question("FIRST QUESTION", "FIRST ANSWER")));
    }

    @Test
    void addTwiceQuestionOnly() {
        out.add(new Question("FIRST QUESTION", "FIRST ANSWER"));
        Assertions.assertThrows((QuestionAlreadyExistException.class), () -> out.add(new Question("FIRST QUESTION", "ANOTHER ANSWER")));
    }

    @Test
    void remove() {
        out.add(new Question("FIRST QUESTION", "FIRST ANSWER"));
        Assertions.assertDoesNotThrow(() -> out.remove(new Question("FIRST QUESTION", "FIRST ANSWER")));
    }

    @Test
    void removeNotExistQuestion() {
        Assertions.assertThrows(QuestionIsNotExistException.class, () -> out.remove(new Question("FIRST QUESTION", "FIRST ANSWER")));
    }

    @Test
    void getAll() {
        Set<Question> result = new HashSet<>();
        result.add(new Question("FIRST QUESTION", "FIRST ANSWER"));
        result.add(new Question("SECOND QUESTION", "SECOND ANSWER"));
        out.add(new Question("FIRST QUESTION", "FIRST ANSWER"));
        out.add(new Question("SECOND QUESTION", "SECOND ANSWER"));
        Set<Question> expected = Set.copyOf(out.getAll());
        assertEquals(result, expected);
    }
}