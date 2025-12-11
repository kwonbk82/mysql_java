package com.tomato.demo;

import com.tomato.demo.used.Greet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	Greet greet;

	private void execute(){
		greet.greeting();
	}
	public static void main(String[] args) {
//		MorningGreet mg  = new MorningGreet();
//		mg.greeting();


		SpringApplication.run(DemoApplication.class, args)
				.getBean(DemoApplication.class).execute();
	}

}
