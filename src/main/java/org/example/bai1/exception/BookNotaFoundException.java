package org.example.bai1.exception;

public class BookNotaFoundException extends RuntimeException {
    public BookNotaFoundException(String message) {
        super(message);
    }
}
