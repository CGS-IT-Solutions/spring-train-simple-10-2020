package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.repository.ChatMessageRepositoryTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpleRestControllerTrainerTest {
  Logger logger = LoggerFactory.getLogger(ChatMessageRepositoryTest.class);

  @Autowired
  private SimpleRestController controller;

  @Test
  void testGetEcho() {
    String echoString = controller.echo();
    assertThat(echoString).isNotBlank();
    logger.info("echoString: " + echoString);
  }

  @Test
  void testGetPropertySingleton() {
    String greeting = controller.getPropertySingleton("myInput");
    assertThat(greeting).isNotBlank();
    logger.info("greeting: " + greeting);
  }
}
