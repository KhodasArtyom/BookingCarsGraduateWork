package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.users.Users;

import java.util.List;
import java.util.Optional;

public class UsersJpaRepository extends BaseJpaRepository<Users, Long> implements UsersRepository {
    public UsersJpaRepository() {
        super(Users.class);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return entityManager.createQuery("""
                        SELECT users
                        FROM Users users
                        WHERE lower(users.email) = lower(:email)
                        """, Users.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }

    @Override
    public List<Users> findByName(String name) {
        return entityManager.createQuery("""
                        SELECT users
                        FROM  Users users
                        WHERE users.name = : name
                        """, Users.class)
                .setParameter("name", name)
                .getResultList();
    }
}
