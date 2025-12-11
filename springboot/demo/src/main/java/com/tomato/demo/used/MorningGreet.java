package com.tomato.demo.used;

import org.springframework.stereotype.Component;

@Component
public class MorningGreet implements Greet{
    @Override
    public void greeting() {
        System.out.println("______________");
        System.out.println("상쾌한 아침");
        System.out.println("______________");
    }
}
