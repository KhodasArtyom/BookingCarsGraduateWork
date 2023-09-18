package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.admin.Admin;
import com.by.khodasartyom.model.entityandDto.users.User;

import java.util.Optional;

public class UserJpaRepository extends BaseJpaRepository<User,Long> implements UserRepository{
    public UserJpaRepository() {
        super(User.class);
    }


    @Override
    public Optional<User> findByEmail(String email) {
        return entityManager.createQuery("""
                        SELECT user
                        FROM User user
                        WHERE user.email = :email
                        """, User.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst();
    }
}
