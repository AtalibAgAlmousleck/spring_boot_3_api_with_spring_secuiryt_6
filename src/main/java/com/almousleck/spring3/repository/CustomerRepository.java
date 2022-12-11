package com.almousleck.spring3.repository;

import com.almousleck.spring3.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    void deleteCustomerById(Long id);
    Optional<Customer> findCustomerById(Long id);
}
