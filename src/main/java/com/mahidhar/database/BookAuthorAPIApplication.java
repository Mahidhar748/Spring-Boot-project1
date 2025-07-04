package com.mahidhar.database;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class BookAuthorAPIApplication {

    public static void main(String[] args) {
		SpringApplication.run(BookAuthorAPIApplication.class, args);
	}

}
