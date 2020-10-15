package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.properties.PropertiesSample;
import at.cgsit.training.firstexample.properties.SingletonPropertyExample;
import at.cgsit.training.firstexample.qualifier.TestQualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simplerest")
public class SimpleRestController {
  Logger logger = LoggerFactory.getLogger(SimpleRestController.class);

  @Autowired
  @Qualifier("testQuaifierComponent")
  private TestQualifier testQualifier;

  @GetMapping("/echo")
  String echo() {
    logger.info("echo");
    return testQualifier.echo("");
  }

}
