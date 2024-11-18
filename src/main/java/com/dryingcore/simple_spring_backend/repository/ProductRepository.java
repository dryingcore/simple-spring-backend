package com.dryingcore.simple_spring_backend.repository;

import com.dryingcore.simple_spring_backend.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {}
