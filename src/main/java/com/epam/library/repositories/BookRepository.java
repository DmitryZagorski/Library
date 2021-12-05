package com.epam.library.repositories;

import com.epam.library.models.Book;

import java.time.LocalDate;

public interface BookRepository {

    void addBook();

    void removeBook();

    Book getById();

    Book getByTitle();



}
