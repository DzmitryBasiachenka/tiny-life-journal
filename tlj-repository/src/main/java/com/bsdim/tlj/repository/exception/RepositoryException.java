package com.bsdim.tlj.repository.exception;

/**
 * The repository exception.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class RepositoryException extends RuntimeException {
    /**
     * Parametrized constructor.
     *
     * @param exception the ecxeption.
     */
    public RepositoryException(Throwable exception) {
        super(exception);
    }

    /**
     * Parametrized constructor.
     *
     * @param message the message.
     * @param cause the ecxeption.
     */
    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
