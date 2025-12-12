package com.tomato.demo.param;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ParamForm {
    private String name;
    private Integer age;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birth;
}
