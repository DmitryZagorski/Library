package com.epam.library.repositories;

import com.epam.library.models.Customer;

import java.util.Collection;
import java.util.Date;

public interface CustomerRepository {

    void addCustomer(Customer customer);

    void removeCustomerById(Integer id);

    void removeAllCustomers();

    Customer getCustomerById(Integer id);

    Customer getCustomerByNameAndSurname(String name, String surname);

    Collection<Customer> getCustomersByDateOfSignUp(Date fromDate, Date toDate);

    Collection<Customer> getAllCustomers();


}
