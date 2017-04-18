package com.bsdim.tlj.repository.exception;

public class RepositoryException extends RuntimeException {
    public RepositoryException(Throwable e) {
        super(e);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
