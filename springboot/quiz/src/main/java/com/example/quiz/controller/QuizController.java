package com.example.quiz.controller;

import com.example.quiz.dto.QuizDto;
import com.example.quiz.form.QuizForm;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class QuizController {
    @Autowired
    private QuizService quizService;
    public QuizForm setUpForm(){
        QuizForm form = new QuizForm();
        form.setAnswer(true);
        return form;
    }
    @GetMapping
    public String showList(QuizForm quizForm,Model model){
        quizForm.setNewQuiz(true);
        List<QuizDto> list = quizService.listAll();

        model.addAttribute("list",list);
        model.addAttribute("title","등록화면");
        return "crud";
    }
}
