package com.example.quiz.controller;

import com.example.quiz.dto.QuizDto;
import com.example.quiz.form.QuizForm;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @PostMapping("/insert")
    public String insert(@Validated QuizForm quizForm,
                         BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){
        QuizDto quizDto = new QuizDto();
        quizDto.setQuestion(quizForm.getQuestion());
        quizDto.setAnswer(quizForm.getAnswer());
        quizDto.setAuthor(quizForm.getAuthor());

        if(!bindingResult.hasErrors()){
            quizService.addQuiz(quizDto);
            redirectAttributes.addFlashAttribute("complete","등록완");
            return "redirect:/quiz";
        }
    }
    @GetMapping("/{id}")
    public String showUpdate(@PathVariable Integer id){
        QuizDto quizDto = quizService.findQuiz(id);
        if(!(quizDto == null)){
            quizForm = makeQuizForm(quizDto);
        }
    }

    private QuizDto makeQuizForm(QuizForm quizForm){
        QuizDto quiz = new QuizDto();
        quiz.setId(quizForm.getId());
        quiz.setQuestion(quiz.getQuestion());
        quiz.setAnswer(quiz.getAnswer());
        quiz.setAuthor(quiz.getAuthor());

        return quiz;
    }
    @PostMapping("/update")
    public String update(@Validated QuizForm quizForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        QuizDto quizDto = makeQuizForm(quizForm);
        if(!bindingResult.hasErrors()){
            quizService.changeQuiz(quizDto);
            redirectAttributes.addFlashAttribute("complete","변경완");
            return "redirect:/quiz/"+quizDto.getId();
        }else {
            makeUpdateModel(quizForm,model);
            return "crud";
        }
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") String id,
                         RedirectAttributes redirectAttributes){
        quizService.removeQuiz(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("delcomplete","삭제완")
    }
    @GetMapping("/play")
    public String showQuiz(){

    }
}
