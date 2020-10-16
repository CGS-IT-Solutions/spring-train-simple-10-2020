package at.cgsit.training.firstexample.requestsope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

// Should be a Configuration
public class GlobalCounterConfig {

  // should be a bean construct method
  public GlobalCounter globalCounter() {
   return new GlobalCounter();
  }

}
