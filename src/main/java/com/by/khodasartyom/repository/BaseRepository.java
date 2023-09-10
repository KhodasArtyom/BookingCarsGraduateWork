package com.by.khodasartyom.repository;

import java.util.Optional;

public interface BaseRepository<E,ID>{

    E getReferenceById(ID id);

    Optional<E> findByUd(ID id);

    void create(E entity);

    void remove(E entity);
}
