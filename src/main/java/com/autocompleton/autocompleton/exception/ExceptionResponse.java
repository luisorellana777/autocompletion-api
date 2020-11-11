package com.autocompleton.autocompleton.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(String message, String details) {
        super();
        this.timeStamp = new Date();
        this.message = message;
        this.details = details;
    }
}