package com.tomato.demo.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class ModelController {
    @GetMapping("/model")
    public String helloView(Model model){
        model.addAttribute("msg","타임리프");
        Member m = new Member("aaa","kimminjae");
        model.addAttribute("obj",m);
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("aaa","kimminji"));
        memberList.add(new Member("abb","hanni"));
        memberList.add(new Member("ccc","kanghaerin"));
        model.addAttribute("List",memberList);
        Map<String,Member> memberMap = new HashMap<>();
        memberMap.put("1",new Member("ddd","faker"));
        memberMap.put("2",new Member("eee","doran"));
        model.addAttribute("map",memberMap);
        return "helloThymeleaf";
    }

//    public String helloView(Model model){
//        model.addAttribute("msg","타임리프");
//        return "helloThymeleaf";
//    }
}
