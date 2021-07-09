package com.github.sithumonline.repository;

import org.hibernate.Session;

import java.util.List;

public interface SuperRepository<T, ID> {

    void setSession(Session session)throws Exception;

    boolean save(T t)throws Exception;

    void delete(T t)throws Exception;

    boolean update(T t)throws Exception;

    T findById(ID id)throws Exception;

    List<T> findAll() throws Exception;

}
