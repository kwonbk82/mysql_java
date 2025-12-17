package com.macademy.shop.member.service;

import com.macademy.shop.member.dto.MemberDto;
import com.macademy.shop.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public int insertMember(MemberDto memberDto){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);

        return  memberMapper.insertMember(memberDto);
    }
}
