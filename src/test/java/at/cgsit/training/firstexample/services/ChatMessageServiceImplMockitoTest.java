package at.cgsit.training.firstexample.services;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.firstexample.repository.ChatMessageRepository;
import at.cgsit.training.firstexample.repository.ChatMessageRepositoryTest;
import at.cgsit.training.firstexample.translator.ChatMessageToChatMessageDTO;
import at.cgsit.training.firstexample.utils.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class ChatMessageServiceImplMockitoTest {

  public static final String MOCKSENDER = "TTTT";
  Logger logger = LoggerFactory.getLogger(ChatMessageRepositoryTest.class);

  @Autowired
  private ChatMessageService chatMessageService;

  @MockBean
  private ChatMessageRepository mockRepository;

  @Autowired
  private ChatMessageToChatMessageDTO converter;

  @Test
  public void testsaveOrUpdateChatMessageDTOSimple() {
      ChatMessage chatMessage = TestDataGenerator.getChatMessage();
      chatMessage.setSender(MOCKSENDER);
      ChatMessageDTO cmDTO = converter.convert(chatMessage);

      when(mockRepository.save(ArgumentMatchers.any())).thenReturn(chatMessage);

      ChatMessage chatMessageSaved = chatMessageService.saveOrUpdateChatMessageDTO(cmDTO);
      assertThat(chatMessageSaved).isNotNull();
  }

  @ParameterizedTest
  @ValueSource(strings = { "chris","franky"})
  public void testFindBySenderWithOrderBy(String userName) {

    ChatMessage chatMessage = TestDataGenerator.getChatMessage();
    chatMessage.setSender(MOCKSENDER);
    ArrayList<ChatMessage> chatMessages = new ArrayList<>();
    chatMessages.add(chatMessage);

    when(mockRepository.findBySender(ArgumentMatchers.any())).thenReturn(chatMessages);

    List<ChatMessage> resultList = chatMessageService.findBySender(userName);
    assertThat(resultList).isNotNull();
    ChatMessage chatMessage1 = resultList.get(0);
    assertThat(chatMessage1.getSender()).isEqualTo(MOCKSENDER);

  }

}
