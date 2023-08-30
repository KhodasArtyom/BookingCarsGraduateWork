package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.Cars;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E,Long > {

   Optional<E> findById(Long id);


   void create(E entity);

   void remove(E entity);
}
