package com.example.coursework2.services.impl;

import com.example.coursework2.exceptions.QuestionAlreadyExistException;
import com.example.coursework2.exceptions.QuestionIsNotExistException;
import com.example.coursework2.models.Question;
import com.example.coursework2.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();

//    public JavaQuestionService() {
//        questions.add(question1);
//        questions.add(question2);
//        questions.add(question3);
//    }
//    Question question1 = new Question("Вопрос номер 1", "Ответ на вопрос номер 1");
//    Question question2 = new Question( "Вопрос номер 2", "Ответ на вопрос номер 2");
//    Question question3 = new Question("Вопрос номер 3", "Ответ на вопрос номер 3");

    @Override
    public Question add(String question, String answer) {
        return new Question(question, answer);
    }

    @Override
    public Question add(Question newQuestion) {
        if (questions.contains(newQuestion)) {
            throw new QuestionAlreadyExistException();
        }
        for (Question question : questions) {
            if (question.getQuestion().equals((newQuestion.getQuestion()))) {
                throw new QuestionAlreadyExistException();
            }

        }
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        } else throw new QuestionIsNotExistException();
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random rnd = new Random();
        return questions.get(rnd.nextInt(questions.size()));
    }
}
