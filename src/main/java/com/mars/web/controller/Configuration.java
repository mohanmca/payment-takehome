package com.mars.web.controller;

import com.mars.constants.DefaultDummyConfigurations;
import com.mars.entities.Plain;
import com.mars.service.RandomRoverFactory;
import com.mars.service.RoverFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
  @Bean
  public RoverFactory getFactory() {
    return RandomRoverFactory.getInstance();
  }

  @Bean
  public Plain getPlain() {
    return DefaultDummyConfigurations.DEFAULT_PLAIN;
  }
}
