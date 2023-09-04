package com.by.khodasartyom.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public abstract class BaseJPARepository<E, Long> implements BaseRepository<E, Long> {
    protected EntityManager entityManager;
    private final Class<E> eClass;

    @Override
    public Optional<E> findById(Long id) {
        return Optional.ofNullable(entityManager.find(eClass, id));
    }

    @Override
    public void create(E entity) {
        entityManager.persist(entity);

    }

    @Override
    public void remove(E entity) {
        entityManager.remove(entity);

    }
}

