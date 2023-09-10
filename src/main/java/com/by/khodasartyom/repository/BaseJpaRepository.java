package com.by.khodasartyom.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseJpaRepository<E, ID> implements BaseRepository<E, ID> {

    @PersistenceContext
    protected EntityManager entityManager;
    private final Class<E> eClass;

    @Override
    public E getReferenceById(ID id) {
        return entityManager.getReference(eClass, id);
    }

    @Override
    public Optional<E> findByUd(ID id) {
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
