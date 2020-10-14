package at.cgsit.training.firstexample.repository;

import at.cgsit.training.firstexample.chat.model.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * spring data respository
 */
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

}
