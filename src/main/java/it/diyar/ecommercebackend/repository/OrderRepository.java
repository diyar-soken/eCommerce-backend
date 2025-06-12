package it.diyar.ecommercebackend.repository;

import it.diyar.ecommercebackend.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
