package com.epam.library.models;

import java.time.LocalDate;

public class Book {

    private int id;
    private static int ID;
    private String name;
    private String author;
    private LocalDate issueDate;
    private String genre;

    public Book() {
    }

    public Book(String name, String author, LocalDate issueDate, String genre) {
        this.id = ID++;
        this.name = name;
        this.author = author;
        this.issueDate = issueDate;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setID(int ID) {
        Book.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
