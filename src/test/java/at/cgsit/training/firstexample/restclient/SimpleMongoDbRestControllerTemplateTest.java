package at.cgsit.training.firstexample.restclient;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import at.cgsit.training.firstexample.logging.LoggingRequestInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimpleMongoDbRestControllerTemplateTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String basePath;

  @BeforeEach
  public void initbasePath() {
    this.basePath = "http://localhost:" + port + "/trainerrest"; // "/simplerest";

    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    interceptors.add(new LoggingRequestInterceptor());

    // restTemplate.getRestTemplate().setInterceptors(interceptors);

    restTemplate.getRestTemplate().getInterceptors().add(new LoggingRequestInterceptor());

    restTemplate.getRestTemplate()
        .setRequestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

  }

  @Test
  public void getOneChatMessage() throws Exception {

    String urlGETList = basePath + "/chatmessages/5";

    ResponseEntity<ChatMessage> responseEntity = restTemplate.getForEntity(urlGETList, ChatMessage.class);
    ChatMessage objects = responseEntity.getBody();

    MediaType contentType = responseEntity.getHeaders().getContentType();

    HttpStatus statusCode = responseEntity.getStatusCode();

    assertThat(statusCode).isEqualTo(HttpStatus.OK);

    assertThat(objects).isNotNull();

  }

    //@Disabled("Disabled until problems are solved!")
    @Test
    public void getAllChatMessages() throws Exception {

      String urlGETList = basePath +"/chatmessages";

      ResponseEntity<ChatMessage[]> responseEntity = restTemplate.getForEntity(urlGETList, ChatMessage[].class);
      Object[] objects = responseEntity.getBody();
      MediaType contentType = responseEntity.getHeaders().getContentType();
      HttpStatus statusCode = responseEntity.getStatusCode();

      assertThat(statusCode).isEqualTo(HttpStatus.OK);

      assertThat(objects).isNotEmpty();
    }

}

