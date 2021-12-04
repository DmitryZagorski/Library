package com.epam.library.models;

import java.time.LocalDate;

public class Order {

    private int id;
    private Customer customer;
    private Book book;
    private int bookQuantity;
    private PlaceOfReading placeOfReading;
    private LocalDate startDate;
    private LocalDate experienceDate;

    public Order(int id, Customer customer, Book book, int bookQuantity, PlaceOfReading placeOfReading, LocalDate startDate, LocalDate experienceDate) {
        this.id = id;
        this.customer = customer;
        this.book = book;
        this.bookQuantity = bookQuantity;
        this.placeOfReading = placeOfReading;
        this.startDate = startDate;
        this.experienceDate = experienceDate;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public PlaceOfReading getPlaceOfReading() {
        return placeOfReading;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExperienceDate() {
        return experienceDate;
    }

}
