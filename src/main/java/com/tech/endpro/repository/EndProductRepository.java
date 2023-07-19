package com.tech.endpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.endpro.controller.EndProduct;

public interface EndProductRepository extends JpaRepository<EndProduct,Integer> {

}
