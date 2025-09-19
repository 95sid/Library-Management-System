package com.LMS.Exceptions;

public class EmailDuplicateEntryException extends RuntimeException{
    public EmailDuplicateEntryException(String message){
        super(message);
    }
}
