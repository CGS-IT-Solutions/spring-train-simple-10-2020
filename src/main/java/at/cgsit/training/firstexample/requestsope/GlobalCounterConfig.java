package at.cgsit.training.firstexample.requestsope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@Configuration
public class GlobalCounterConfig {

  @Bean
  @ApplicationScope // using web specific session scopes
  public GlobalCounter globalCounter() {
   return new GlobalCounter();
  }

}
