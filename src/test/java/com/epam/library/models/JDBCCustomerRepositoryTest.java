package com.epam.library.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.Collection;

class JDBCCustomerRepositoryTest {

    @Test
    void addCustomer() {

        JDBCCustomerRepository instance = JDBCCustomerRepository.getInstance();

        Customer c1 = new Customer();
        c1.setName("Dmitry");
        c1.setSurname("Zagorski");
        c1.setBirth(Date.valueOf("1990-07-21"));
        c1.setAddress("Grodno");

        Customer c2 = new Customer();
        c2.setName("Anton");
        c2.setSurname("Varenikow");
        c2.setBirth(Date.valueOf("1992-12-10"));
        c2.setAddress("Minsk");

        instance.removeAllCustomers();

        instance.addCustomer(c1);
        instance.addCustomer(c2);

        Collection<Customer> allCustomers = instance.getAllCustomers();

        Assertions.assertEquals(2, allCustomers.size());

    }

    @Test
    void removeCustomer() {
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void getAllCustomers() {
    }
}