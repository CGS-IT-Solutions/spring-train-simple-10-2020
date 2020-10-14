package at.cgsit.training.firstexample.utils;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.chat.model.MessageType;

public class TestDataGenerator {


  public static ChatMessage getChatMessage() {
    //given
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setSender("john doe");
    chatMessage.setContent("test ChatMessageDaoTest");
    chatMessage.setRecipient("frank");
    chatMessage.setType(MessageType.CHAT);
    return chatMessage;
  }


}
