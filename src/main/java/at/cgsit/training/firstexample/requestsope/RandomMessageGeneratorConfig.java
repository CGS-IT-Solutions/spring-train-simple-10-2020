package at.cgsit.training.firstexample.requestsope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Configuration
public class RandomMessageGeneratorConfig {

  @Bean
  @SessionScope  // using web specific session scopes
  public RandomMessageGenerator randomMessageBean() {
    UUID uuid = UUID.randomUUID();
    return new RandomMessageGenerator(uuid.toString());
  }

}
