package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.Manager;

import java.util.Optional;

public class ManagerJPARepo extends BaseJPARepository<Manager, Long> implements ManagerRepo {
    public ManagerJPARepo() {
        super(Manager.class);
    }

    @Override
    public Optional<Manager> findById(String email) {
        return entityManager.createQuery("""
                SELECT manager
                FROM Manager manager
                WHERE lower(manager.email) = lower(email)
                """,Manager.class)
                .setParameter("email",email)
                .getResultStream()
                .findFirst();
    }


}
