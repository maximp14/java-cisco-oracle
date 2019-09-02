package com.controller;

import java.util.ArrayList;
import java.util.List;

public interface DAO <T,K> {

    void create(T t);

    T findById(K k);

    List<T> findAll();

    void update(K k, T t);

    boolean delete(K k);

}
