package com.bsdim.tlj.repository.exception;

/**
 * The system exception.
 * <p>
 * Date: 2017-11-27
 *
 * @author Dzmitry Basiachenka
 */
public class SystemException extends RuntimeException {
    /**
     * Parametrized constructor.
     *
     * @param exception the exception.
     */
    public SystemException(Throwable exception) {
        super(exception);
    }
}
