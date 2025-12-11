package com.tomato.demo.used;

public class EveningGreet implements Greet{
    @Override
    public void greeting() {
        System.out.println("______________");
        System.out.println("좋은 저녁");
        System.out.println("______________");
    }
}
