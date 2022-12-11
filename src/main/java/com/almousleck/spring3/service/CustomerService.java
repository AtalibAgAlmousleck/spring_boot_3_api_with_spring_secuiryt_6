package com.almousleck.spring3.service;

import com.almousleck.spring3.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer registerCustomer(Customer customer);
    List<Customer> fetchCustomers();
    Customer findCustomerById(Long id);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}
