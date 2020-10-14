package at.cgsit.training.firstexample.chat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ChatMessage implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private MessageType type;

  private String content;

  private String sender;

  private String recipient;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }



  public MessageType getType() {
    return type;
  }

  public ChatMessage setType(MessageType type) {
    this.type = type;
    return this;
  }

  public String getContent() {
    return content;
  }

  public ChatMessage setContent(String content) {
    this.content = content;
    return this;
  }

  public String getSender() {
    return sender;
  }

  public ChatMessage setSender(String sender) {
    this.sender = sender;
    return this;
  }

  public String getRecipient() {
    return recipient;
  }

  public ChatMessage setRecipient(String recipient) {
    this.recipient = recipient;
    return this;
  }
}
