package at.cgsit.training.firstexample.dao;


import at.cgsit.training.firstexample.chat.model.ChatMessage;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ChatMessageDao extends AbstractJpaDao<ChatMessage> implements IAbstractJpaDao<ChatMessage> {

    public ChatMessageDao(){
      setClazz(ChatMessage.class );
    }

  }
