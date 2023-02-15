package dev.danvega.jpasecurity.repository;


import dev.danvega.jpasecurity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByUser_Id(int userId);
    Optional<Product> findByMacId(String s);
}
