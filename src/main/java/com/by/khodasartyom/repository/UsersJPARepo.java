package com.by.khodasartyom.repository;

import com.by.khodasartyom.entity.users.Users;

import java.util.List;
import java.util.Optional;

public class UsersJPARepo extends BaseJPARepository<Users, Long> implements UsersRepo {


    public UsersJPARepo() {
        super(Users.class);
    }


    @Override
    public List<Users> findByEmail(String email) {
        return entityManager.createQuery("""
                        SELECT users.email FROM Users users
                        WHERE users.email = :email
                        """,Users.class)
                .setParameter("email",email)
                .getResultList();
    }

    @Override
    public List<Users> findByName(String name) {
        return entityManager.createQuery("""
                        SELECT users.name FROM Users users
                        WHERE users.name = :email
                        ORDER BY users.name ASC
                        """,Users.class)
                .setParameter("name",name)
                .getResultList();
    }
}
