package at.cgsit.training.firstexample.repository;


import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.chat.model.MessageType;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import at.cgsit.training.firstexample.utils.TestDataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.List;


//@DataJpaTest
@SpringBootTest
public class ChatMessageRepositoryTest {

  Logger logger = LoggerFactory.getLogger(ChatMessageRepositoryTest.class);

  @Autowired
  private ChatMessageRepository chatMessageRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @BeforeEach
  public void tearDown() {
      // JdbcTestUtils.deleteFromTables(jdbcTemplate, "chat_message");
  }

  @Test
  public void testFindBySenderWithOrderBy() {

    List<ChatMessage> bySender = chatMessageRepository.findByXYZ("Chris");

    bySender.stream().forEach( e -> logger.info("sender {} time {}", e.getSender(), e.getErstelldatum() ));

    assertThat(bySender).isNotNull();
    // assertThat(bySender.size()).isGreaterThan(1);
  }


  @Test
  public void testFindBySender() {
    List<ChatMessage> bySender = chatMessageRepository.findBySender("Chris");
    assertThat(bySender).isNotNull();
    // assertThat(bySender.size()).isGreaterThan(0);
  }


  @Test
  public void testPersistence() {

    ChatMessage chatMessage = TestDataGenerator.getChatMessage();

    //when
    ChatMessage saved = chatMessageRepository.save(chatMessage);

    chatMessage.setSender("Chris");
    chatMessage.setId(null);
    chatMessageRepository.save(chatMessage);

    assertThat(saved.getId()).isNotNull();
    assertThat(chatMessage.getId()).isNotNull();

    ChatMessage newChatMessage1 = chatMessageRepository.findById(chatMessage.getId()).orElse(null);
    assertThat( newChatMessage1.getId() ).isGreaterThanOrEqualTo(1L);
  }

}

