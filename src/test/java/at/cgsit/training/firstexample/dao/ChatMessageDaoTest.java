package at.cgsit.training.firstexample.dao;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.chat.model.MessageType;
import at.cgsit.training.firstexample.repository.ChatMessageRepositoryTest;
import at.cgsit.training.firstexample.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatMessageDaoTest {
  Logger logger = LoggerFactory.getLogger(ChatMessageDaoTest.class);

  @Autowired
  private IAbstractJpaDao<ChatMessage> chatMessageDao;


  @Test
  public void testCustomConnection() {

    ChatMessage oneSpezial = chatMessageDao.findOneSpezial(1);

    // assertThat(oneSpezial).isNotNull();

    if(oneSpezial==null) {
      logger.info("testCustomConnection");
    }

  }

  @Test
  public void testPersistence() {
    ChatMessage chatMessage = TestDataGenerator.getChatMessage();

    chatMessageDao.create(chatMessage);

    ChatMessage newChatMessage1 = chatMessageDao.findOne(chatMessage.getId());

    assertThat( newChatMessage1.getId() ).isGreaterThanOrEqualTo(1L);
  }

}
