package com.example.quiz.mapper;

import com.example.quiz.dto.QuizDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuizMapper {
    int addQuiz(QuizDto dto);
    List<QuizDto> listAll();
    QuizDto findQuiz(int id);
    int changeQuiz(QuizDto dto);
    int removeQuiz(int id);

//    <select id="playQuiz" parameterType="Map" resultType="boolean">
    Boolean playQuiz(Map map);
}
