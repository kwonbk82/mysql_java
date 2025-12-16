package com.example.quiz;

import com.example.quiz.dto.QuizDto;
import com.example.quiz.service.QuizService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QuizServiceTest {
    @Autowired
    private QuizService quizService;

    @Test
    void testQuiz(){
        QuizDto quiz = new QuizDto("질문1",true, "테스터훈");
        int result = quizService.addQuiz(quiz);

        assertThat(result).isEqualTo(1);
    }
    @Test
    void listAllTest(){
        QuizDto quiz = new QuizDto("질문2",true, "테스터2");
        quizService.addQuiz(quiz);
        List<QuizDto> result = quizService.listAll();
        assertThat(result.size()).isEqualTo(quiz.getId());
    }
    @Test
    void findQuizTest(){
        QuizDto quiz = new QuizDto("1+1=2",true,"테스터3");
        quizService.addQuiz(quiz);
        QuizDto dto = quizService.findQuiz(quiz.getId());
        assertThat(dto.getQuestion()).isEqualTo(quiz.getQuestion());
    }
    @Test
    void changeQuizTest(){
        QuizDto quiz = new QuizDto("2+2=5",true,"테스터4");
        quizService.addQuiz(quiz);
        quiz.setAnswer(false);
        int result = quizService.changeQuiz(quiz);
        assertThat(result).isEqualTo(1);

    }
    @Test
    void removeQuizTest(){
        QuizDto quiz = new QuizDto("1+1=3",false,"테스터5");
        quizService.addQuiz(quiz);

        int rId = quiz.getId();

        int result1  = quizService.removeQuiz(quiz.getId());
        QuizDto result2 = quizService.findQuiz(rId);
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isNull();
    }
    @Test
    void playQuizTest(){
        QuizDto quiz = new QuizDto("1+1=2",true,"테스터6");
        Map map = new HashMap();
        map.put("id",quiz.getId());
        map.put("answer",true);

        boolean result =  quizService.playQuiz(map);
        assertThat(result).isTrue();

        map.put("answer",false);
        boolean result2 =  quizService.playQuiz(map);
        assertThat(result2).isFalse();


    }
}
