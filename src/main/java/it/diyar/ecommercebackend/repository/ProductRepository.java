package it.diyar.ecommercebackend.repository;

import it.diyar.ecommercebackend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
