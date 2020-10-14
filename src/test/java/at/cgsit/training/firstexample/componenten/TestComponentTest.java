package at.cgsit.training.firstexample.componenten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestComponentTest {

  @Autowired
  TestComponent testComponent;

  @Test
  void simpleTestComponentEchoTest() {
    assertThat(testComponent).isNotNull();
    String test_it = testComponent.echo("test it");
    assertThat(test_it).isEqualTo("test it");
  }


}
