package com.macademy.shop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.BeanProperty;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/**").permitAll())
                .formLogin(formLogin->formLogin.loginPage("/member/login")
                        .defaultSuccessUrl("/",true).usernameParameter("id")
                        .failureUrl("/member/login/error"))
                .logout(logout -> logout.logoutUrl("/members/logout")
                        .logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("JSESSIONID"))
                .exceptionHandling(exception->exception
                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint()));
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
