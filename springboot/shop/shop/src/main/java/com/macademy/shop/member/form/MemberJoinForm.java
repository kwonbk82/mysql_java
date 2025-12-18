package com.macademy.shop.member.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class MemberJoinForm {
    @NotBlank(message = "아이디는 필수입력 값입니다.")
    private String id;
    @NotEmpty(message = "비밀번호는 필수입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8~16글자로 입력." )
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,16}$")
    private String password;
    @NotBlank(message = "이름은 필수입력 값입니다.")
    private String name;
    @NotBlank(message = "이메일은 필수입력값입니다")
    @Email(message = "이메일 형식으로 입력해주세요")
    private String email;
    private String address;
}
