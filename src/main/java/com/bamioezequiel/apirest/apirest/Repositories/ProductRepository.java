package com.bamioezequiel.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bamioezequiel.apirest.apirest.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
