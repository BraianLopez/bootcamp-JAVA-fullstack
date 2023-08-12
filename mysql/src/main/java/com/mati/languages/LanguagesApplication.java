package com.mati.languages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LanguagesApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(LanguagesApplication.class, args);
    }
}
