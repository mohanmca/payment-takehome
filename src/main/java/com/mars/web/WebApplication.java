package com.mars.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebApplication {

  @Value("${testKey}")
  private String key;

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(WebApplication.class, args);
    WebApplication application = context.getBean(WebApplication.class);
    System.out.println(application);
  }
}
