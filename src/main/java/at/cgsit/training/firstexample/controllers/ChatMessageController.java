package at.cgsit.training.firstexample.controllers;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.dto.ChatMessageDTO;
import at.cgsit.training.firstexample.services.ChatMessageService;
import at.cgsit.training.firstexample.translator.ChatMessageToChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ChatMessageController {

    private ChatMessageService chatMessageService;

    private ChatMessageToChatMessageDTO cmToCMDTO;

    @Autowired
    public void setCmToCMDTO(ChatMessageToChatMessageDTO cmToCMDTO) {
      this.cmToCMDTO = cmToCMDTO;
    }

    @Autowired
    public void setChatMessageService(ChatMessageService chatMessageService) {
      this.chatMessageService = chatMessageService;
    }

    @RequestMapping("/")
    public String redirToList(){
      return "redirect:/chatmessage/list";
    }

    @RequestMapping({"/chatmessage/list", "/chatmessage"})
    public String listChatMessages(Model model){
      model.addAttribute("chatmessagelist", chatMessageService.listAll());
      return "chatmessage/list";
    }


}
