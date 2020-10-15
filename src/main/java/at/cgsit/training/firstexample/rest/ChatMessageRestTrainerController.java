package at.cgsit.training.firstexample.rest;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.repository.ChatMessageRepository;
import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.translator.ChatMessageToChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ChatMessageRestTrainerController {

  private ChatMessageService chatMessageService;

  private ChatMessageToChatMessageDTO cmToCMDTO;

  private ChatMessageRepository repository;

  @Autowired
  public void setRepository(ChatMessageRepository repository) {
    this.repository = repository;
  }

  @Autowired
  public void setCmToCMDTO(ChatMessageToChatMessageDTO cmToCMDTO) {
    this.cmToCMDTO = cmToCMDTO;
  }

  @Autowired
  public void setChatMessageService(ChatMessageService chatMessageService) {
    this.chatMessageService = chatMessageService;
  }


  @GetMapping("/chatmessages")
  public List<ChatMessage> all() {
    return chatMessageService.listAll();
  }

  @GetMapping("/chatmessages/findBySender/{sender}")
  public List<ChatMessage> findBySender(@PathVariable String sender) {
    return chatMessageService.findBySender(sender);
  }


}
