package com.solvd.post.customException;

public class DimensionsValidationException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Wrong data try again leading this pattern 0.00";
    }
}
