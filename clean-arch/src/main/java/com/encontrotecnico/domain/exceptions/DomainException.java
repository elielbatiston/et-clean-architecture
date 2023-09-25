package com.encontrotecnico.domain.exceptions;

public class DomainException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DomainException(final String msg) {
        super(msg);
    }
}
