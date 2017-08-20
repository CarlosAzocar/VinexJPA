package com.org.repositories;

import java.io.Serializable;
import java.util.List;

public interface IRepository<T, PK extends Serializable> {

    List<T> getAll() throws Exception;

    T create(T entity) throws Exception;

    T read(PK key) throws Exception;

    T update(T entity) throws Exception;

    void delete(T entity) throws Exception;
}