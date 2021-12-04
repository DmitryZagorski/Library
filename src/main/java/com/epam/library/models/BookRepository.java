package com.epam.library.models;

import java.time.LocalDate;

public interface BookRepository {

    void addBook();

    void removeBook();

    Book getById();

}
