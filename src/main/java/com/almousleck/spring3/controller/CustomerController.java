package com.almousleck.spring3.controller;

import com.almousleck.spring3.models.Customer;
import com.almousleck.spring3.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> fetchCustomer() {
        return ResponseEntity.ok(customerService.fetchCustomers());
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.registerCustomer(customer));
    }

    @GetMapping("/single/{id}")
    public ResponseEntity<Customer> getSingleCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable("id") Long id,
            @RequestBody Customer customer) {
        customer.setId(id);
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
