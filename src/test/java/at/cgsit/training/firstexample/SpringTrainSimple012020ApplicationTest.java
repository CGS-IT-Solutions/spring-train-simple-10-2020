package at.cgsit.training.firstexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringTrainSimple012020ApplicationTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  void contextLoads() {
    assertThat(applicationContext).isNotNull();
    String displayName = applicationContext.getDisplayName();
    assertThat(displayName).isNotBlank();
    String applicationName = applicationContext.getApplicationName();
    assertThat(applicationName).isNotNull();
  }


}
