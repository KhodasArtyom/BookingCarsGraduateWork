package com.by.khodasartyom.repository;

import com.by.khodasartyom.model.entityandDto.admin.Admin;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AdminJpaRepository extends BaseJpaRepository<Admin, Long> implements AdminRepository {
    public AdminJpaRepository() {
        super(Admin.class);
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return entityManager.createQuery("""
                        SELECT admin 
                        FROM Admin admin
                        WHERE admin.email = :email
                        """,Admin.class)
                .setParameter("email",email)
                .getResultStream()
                .findFirst();
    }
}
