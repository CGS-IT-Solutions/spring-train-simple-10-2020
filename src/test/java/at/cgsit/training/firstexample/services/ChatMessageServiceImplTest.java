package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.componenten.SingletonPropertyExample;
import at.cgsit.training.firstexample.repository.ChatMessageRepository;
import at.cgsit.training.firstexample.repository.ChatMessageRepositoryTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles( {"mocktest"}) // use "dummy" if you like the DevChatMesageService itself
class ChatMessageServiceImplTest {
  Logger logger = LoggerFactory.getLogger(ChatMessageRepositoryTest.class);

  @Autowired
  private ChatMessageService chatMessageService;

  @Autowired
  @Qualifier("chatMessageRepositoryStubImpl")
  private ChatMessageRepository chatMessageRepository;

  @Autowired
  private SingletonPropertyExample singletonPropertyExample;

  @Test
  public void testSimpleProperty() {
    String message = singletonPropertyExample.getMessage();
    assertThat(message).isNotNull();
    logger.info("singletonPropertyExample messagage: {}", message);
  }


  @ParameterizedTest
  @ValueSource(strings = {
      "chris",
      "franky"})
  public void testFindBySenderWithOrderBy(String userName) {

    List<ChatMessage> chris = chatMessageService.findBySender(userName);
    assertThat(chris).isNotNull();
  }

}
