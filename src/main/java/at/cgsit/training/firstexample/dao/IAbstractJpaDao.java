package at.cgsit.training.firstexample.dao;

import at.cgsit.training.firstexample.chat.model.ChatMessage;

import java.io.Serializable;
import java.util.List;

public interface IAbstractJpaDao<T extends Serializable> {
  T findOne(long id);

  List<T> findAll();

  void create(T entity);

  T update(T entity);

  void delete(T entity);

  void deleteById(long entityId);

  public ChatMessage findOneSpezial(long id);

}
