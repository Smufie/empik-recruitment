package com.jolszewski.util;

public class CannotMakeCalculationsException extends RuntimeException {

    public CannotMakeCalculationsException() {
    }

    public CannotMakeCalculationsException(String message) {
        super(message);
    }
}
