package com.example.milestone1b;
import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Milestone1BApplication extends HttpServlet {

    public static void main(String[] args) {
        SpringApplication.run(Milestone1BApplication.class, args);
    }

}
