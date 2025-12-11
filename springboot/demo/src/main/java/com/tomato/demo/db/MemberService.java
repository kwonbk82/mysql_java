package com.tomato.demo.db;

import com.tomato.demo.db.dao.MemberMapper;
import com.tomato.demo.db.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public List<MemberDto> list(){
        List<MemberDto> memberList = memberMapper.list();
        return memberList;
    }
}
