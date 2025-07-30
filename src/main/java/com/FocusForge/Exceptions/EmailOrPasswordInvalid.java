package com.FocusForge.Exceptions;

public class EmailOrPasswordInvalid  extends RuntimeException{
    public EmailOrPasswordInvalid (String message) {
        super(message);
    }

}
