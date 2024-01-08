package com.solvd.post.customException;

public class PassportValidationException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Wrong data try again, First two letters must be capital after seven digital";
    }
}
