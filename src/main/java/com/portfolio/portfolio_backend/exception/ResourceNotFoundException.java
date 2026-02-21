// ResourceNotFoundException.java
package com.portfolio.portfolio_backend.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

