package com.epam.library.models;

import java.util.Collection;

public interface CustomerRepository {

    void addCustomer(Customer customer);

    void removeCustomerById(Integer id);

    void removeAllCustomers();

    Customer getCustomerById(Integer id);

    Collection<Customer> getAllCustomers();


}
