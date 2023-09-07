package com.by.khodasartyom.repository;


import java.util.Optional;

public interface BaseRepository<E,Long > {

   Optional<E> findById(Long id);

   void create(E entity);

   void remove(E entity);
}
