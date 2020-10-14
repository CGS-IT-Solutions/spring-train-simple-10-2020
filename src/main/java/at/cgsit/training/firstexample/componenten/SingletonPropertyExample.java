package at.cgsit.training.firstexample.componenten;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:myextra.properties")
// @PropertySource("file:${app.home}/app.properties")
public class SingletonPropertyExample {

  Logger logger = LoggerFactory.getLogger(TestComponent.class);

  @Autowired
  Environment env;

  @Value("${myapp.name}")
  private String name;

  @Value("${myapp.author}")
  private String author;

  public String getMessage() {

    String property = env.getProperty("myapp.name");
    logger.info("value from ENV {}", property);

    return String.format("Application %s was created by %s", name, author);
  }
}

