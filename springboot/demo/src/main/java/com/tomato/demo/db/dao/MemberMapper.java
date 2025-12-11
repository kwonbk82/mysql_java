package com.tomato.demo.db.dao;

import com.tomato.demo.db.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public List<MemberDto> list();
}