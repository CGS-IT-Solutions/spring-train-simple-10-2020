package at.cgsit.training.firstexample.dao;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.chat.model.MessageType;
import at.cgsit.training.firstexample.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatMessageDaoTest {

  @Autowired
  private IAbstractJpaDao<ChatMessage> chatMessageDao;


  @Test
  public void testCustomConnection() {

    ChatMessage oneSpezial = chatMessageDao.findOneSpezial(1);
    assertThat(oneSpezial).isNotNull();

  }

  @Test
  public void testPersistence() {
    ChatMessage chatMessage = TestDataGenerator.getChatMessage();

    chatMessageDao.create(chatMessage);

    ChatMessage newChatMessage1 = chatMessageDao.findOne(chatMessage.getId());

    assertThat( newChatMessage1.getId() ).isGreaterThanOrEqualTo(1L);
  }

}
