package com.macademy.shop.member.mapper;

import com.macademy.shop.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int insertMember(MemberDto memberDto);
}
