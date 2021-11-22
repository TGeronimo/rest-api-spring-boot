package org.mathero.restapi.ui.exceptions;

public class UserServiceException extends RuntimeException {

    static final long serialVersionUID = 7034897190745766939L;

    public UserServiceException(String message) {
        super(message);
    }
}
