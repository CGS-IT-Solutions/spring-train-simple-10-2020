package at.cgsit.training.firstexample.componenten;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // change to prototype
@PropertySource("classpath:myextra.properties")
public class SingletonPropertyExample {

  @Value("${myapp.name}")
  private String name;

  @Value("${myapp.author}")
  private String author;

  public String getMessage() {

    return String.format("Application %s was created by %s", name, author);
  }
}

