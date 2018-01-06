package com.bsdim.tlj.api.exception;

/**
 * The tlj runtime exception.
 * <p>
 * Date: 2018-01-13
 *
 * @author Dzmitry Basiachenka
 */
public class TLJRuntimeException extends RuntimeException {
    /**
     * Parametrized constructor.
     *
     * @param exception the ecxeption.
     */
    public TLJRuntimeException(Throwable exception) {
        super(exception);
    }
}
