package com.mars.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WebApplicationTest {

  @Autowired private TestRestTemplate template;

  @Test
  public void testSample() throws Exception {
    ResponseEntity<String> response = template.getForEntity("/", String.class);
    assertThat(response.getBody()).contains("Mars planet");
  }
}
