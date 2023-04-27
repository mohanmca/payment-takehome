package com.mars.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@SpringBootApplication
public class WebApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(WebApplication.class);

  @Value("${testKey}")
  private String key;

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(WebApplication.class, args);
    WebApplication application = context.getBean(WebApplication.class);
    System.out.println(application);
  }


}
