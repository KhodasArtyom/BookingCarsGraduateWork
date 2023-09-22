package com.by.khodasartyom.model.car;

import com.by.khodasartyom.model.BaseEntity;
import com.by.khodasartyom.model.admin.Admin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CollectionId;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "car")
@Getter
@Setter
@Accessors(chain = true)
public class Car extends BaseEntity {

    @Column(name = "brand",nullable = false)
    private String brand;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @Column(name = "created_at",nullable = false)
    private Instant createdAt;

    @Column(name ="active_status",nullable = false)
    private boolean active_status;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id",nullable = false)
    private Admin admin;
}
