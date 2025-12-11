package com.tomato.demo.db.controller;

import com.tomato.demo.db.MemberService;
import com.tomato.demo.db.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping(value = "/all")
//    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allMembers(){
        StringBuilder sb = new StringBuilder();
        List<MemberDto> memberList = memberService.list();

        for(MemberDto m :memberList ){
            sb.append(m.getName()+" ");
        }

        return sb.toString();
    }
}
