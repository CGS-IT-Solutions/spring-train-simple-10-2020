package at.cgsit.training.firstexample.dao;

import java.io.Serializable;
import java.util.List;

public interface IAbstractJpaDao<T extends Serializable> {
  T findOne(long id);

  List<T> findAll();

  void create(T entity);

  T update(T entity);

  void delete(T entity);

  void deleteById(long entityId);
}
