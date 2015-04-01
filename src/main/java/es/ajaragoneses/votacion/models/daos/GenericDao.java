package es.ajaragoneses.votacion.models.daos;

import java.util.List;

public interface GenericDao<T, ID> {

    void create(T entity);

    T read(ID id);

    void update(T entity);

    void deleteById(ID id);

    public List<T> findAll();
    
}
