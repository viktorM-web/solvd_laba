package com.solvd.post.customException;

public class NotValidException extends RuntimeException {

    public NotValidException(Exception e) {

    }

    @Override
    public String getMessage() {
        return "wrong data try again";
    }
}
