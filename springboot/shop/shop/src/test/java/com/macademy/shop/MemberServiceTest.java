package com.macademy.shop;

import com.macademy.shop.member.constant.Role;
import com.macademy.shop.member.dto.MemberDto;
import com.macademy.shop.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;
    @Test
    public void insertMemberTest(){
        MemberDto member = new MemberDto();
        member.setId("test2");
        member.setPassword("1234");
        member.setName("kimminji");
        member.setEmail("NJS@gmail.com");
        member.setAddress("seoul");
        member.setRole(Role.USER);

        int result = memberService.insertMember(member);
        assertThat(result).isEqualTo(1);
    }
}
