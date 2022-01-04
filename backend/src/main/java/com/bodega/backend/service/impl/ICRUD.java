package com.bodega.backend.service.impl;

import java.util.List;

public interface ICRUD<E> {
    List<E> findAll();

    E findById(Integer id);

    E save(E e);

    E update(E e);

    boolean delete(Integer id);
}
