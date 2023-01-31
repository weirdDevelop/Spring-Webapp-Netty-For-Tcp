package dev.danvega.jpasecurity.repository;


import dev.danvega.jpasecurity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {


    Optional<Product> findByMacId(String s);
}
