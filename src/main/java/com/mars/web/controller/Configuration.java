package com.mars.web.controller;

import com.mars.service.RoverFactory;
import com.mars.service.RoverFactoryImpl;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
  @Bean
  public RoverFactory getFactory() {
    return RoverFactoryImpl.getInstance();
  }
}
