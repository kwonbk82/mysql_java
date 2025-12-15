package com.example.quiz.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDto {
    private Integer id;
    private String question;
    private Boolean answer;
    private String author;

    public QuizDto(String question, Boolean answer, String author) {
        this.question = question;
        this.answer = answer;
        this.author = author;
    }
}
