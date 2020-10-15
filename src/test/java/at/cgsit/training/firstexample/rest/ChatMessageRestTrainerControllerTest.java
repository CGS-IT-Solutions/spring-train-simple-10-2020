package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.exceptions.ChatMessageNotFoundException;
import at.cgsit.training.firstexample.utils.TestDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatMessageRestTrainerControllerTest {

  @Autowired
  private ChatMessageRestTrainerController controller;

  @Test
  void testCreateChatMessage() {
   ChatMessage chatMessage = TestDataGenerator.getChatMessage();
    chatMessage.setContent("Rest controller test ");

    ChatMessage chatMassage = controller.createChatMassage(chatMessage);
    assertThat(chatMassage).isNotNull();
  }

  @Test
  void testFindByIdNotFound() {
    ChatMessage chatMessage = TestDataGenerator.getChatMessage();
    chatMessage.setContent("Rest controller test ");

    Assertions.assertThrows(ChatMessageNotFoundException.class, () -> {
      controller.findById(666666L);
    });

  }


}


