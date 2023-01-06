package com.revature.POProject1Remake.exceptions;

public class UsernameDoesntExistException extends RuntimeException{
    public UsernameDoesntExistException() {
    }

    public UsernameDoesntExistException(String message) {
        super(message);
    }

    public UsernameDoesntExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDoesntExistException(Throwable cause) {
        super(cause);
    }

    public UsernameDoesntExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
