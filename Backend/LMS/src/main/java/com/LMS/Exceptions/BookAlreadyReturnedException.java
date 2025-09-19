package com.LMS.Exceptions;

public class BookAlreadyReturnedException extends RuntimeException{
    public BookAlreadyReturnedException(String message){
        super(message);
    }
}
