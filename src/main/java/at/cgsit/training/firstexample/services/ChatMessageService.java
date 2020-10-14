package at.cgsit.training.firstexample.services;


import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.dto.ChatMessageDTO;

import java.util.List;

public interface ChatMessageService {

  List<ChatMessage> listAll();

  ChatMessage getById(Long id);

  List<ChatMessage> findBySender(String sender);

  ChatMessage saveOrUpdate(ChatMessage chatMessage);

  void delete(Long id);

  ChatMessage saveOrUpdateChatMessageDTO(ChatMessageDTO cmDTO);

}
