package it.diyar.ecommercebackend.repository;

import it.diyar.ecommercebackend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c")
    List<Customer> getAllCustomers();

    @Query("SELECT c FROM Customer c WHERE c.customerId = :id")
    Optional<Customer> getCustomerById(@Param("id") Long id);

    default Customer createCustomer(Customer customer) {
        return save(customer);
    }
    default Customer updateCustomer(Long id, Customer customer) {
        if (findById(id).isPresent()) {
            customer.setCustomerId(id);
            return save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }
    default void deleteCustomer(Long id) {
        deleteById(id);
    }
}