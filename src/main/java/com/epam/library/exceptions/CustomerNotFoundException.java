package com.epam.library.exceptions;

public class CustomerNotFoundException extends CustomerException {

    private Integer id;

    public CustomerNotFoundException(Integer id){
        this.id = id;
    }

    public CustomerNotFoundException(Integer id, Throwable e){
        super(e);
        this.id = id;
    }

}
