package at.cgsit.training.firstexample.restclient;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ChatMessageRestMockMvcTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnDefaultMessage() throws Exception {

    MvcResult mvcResult = this.mockMvc
        .perform(get("/trainerrest/chatmessages/5"))
        .andDo(print())
        .andExpect(status()
            .isOk()).andReturn();

    String json = mvcResult.getResponse().getContentAsString();

    ChatMessage object = (ChatMessage)new ObjectMapper().readValue(json, ChatMessage.class);

    assertThat(json).isNotNull();
  }

}
