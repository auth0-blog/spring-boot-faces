package com.auth0.samples.bootfaces.persistence;

import com.auth0.samples.bootfaces.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
