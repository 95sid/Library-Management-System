package com.LMS.Exceptions;

public class PhoneDuplicateEntryException extends RuntimeException{
    public PhoneDuplicateEntryException(String message){
        super(message);
    }
}
