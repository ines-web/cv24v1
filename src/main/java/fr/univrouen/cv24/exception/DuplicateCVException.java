package fr.univrouen.cv24.exception;

public class DuplicateCVException extends RuntimeException {
    public DuplicateCVException(String message) {
        super(message);
    }
}