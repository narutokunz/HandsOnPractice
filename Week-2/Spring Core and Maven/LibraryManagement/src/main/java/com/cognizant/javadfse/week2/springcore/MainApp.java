package com.cognizant.javadfse.week2.springcore;

import com.cognizant.javadfse.week2.springcore.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Starting Spring IoC Container...");
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            BookService service = context.getBean("bookServiceBean", BookService.class);
            service.manageLibrary();
        }
        System.out.println("Spring Core exercises completed successfully.");
    }
}
