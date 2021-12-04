package com.epam.library.models;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Customer {

    private int id;
    private static int ID;
    private String name;
    private String surname;
    private java.util.Date birth;
    private String address;

    public Customer() {

    }

    public Customer(String name, String surname, Date birth, String address) {
        this.id = ID++;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirth() {
        return (Date) birth;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setID(int ID) {
        Customer.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(birth, customer.birth) &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                '}';
    }
}
