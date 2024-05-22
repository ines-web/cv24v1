package fr.univrouen.cv24.exception;


public class CVNotFoundException extends RuntimeException {
    public CVNotFoundException(String message) {
        super(message);
    }
}