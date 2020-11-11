package com.autocompletion.autocompletion.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public GeneralException(String message) {
        super(message);
        this.message = message;
    }

}