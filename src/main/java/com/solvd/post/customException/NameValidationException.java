package com.solvd.post.customException;

public class NameValidationException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Wrong data try again, Use only letters, First letters must be capital";
    }
}
