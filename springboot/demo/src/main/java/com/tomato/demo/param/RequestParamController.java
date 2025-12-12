package com.tomato.demo.param;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RequestParamController {
    @GetMapping("/showView")
    public String showView(){
        return "entry";
    }

//    @PostMapping("/confirm")
//    public String confirmView(@RequestParam String name, @RequestParam Integer age, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate birth, Model model){
//        model.addAttribute("name",name);
//        model.addAttribute("age",age);
//        model.addAttribute("birth",birth);
//
//        return "confirm";
//    }

    @PostMapping("/confirm")
    public String confirmView(ParamForm f){

        return "confirm2";
    }

}
