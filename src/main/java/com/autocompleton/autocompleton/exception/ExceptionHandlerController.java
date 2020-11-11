package com.autocompleton.autocompleton.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        ExceptionResponse exceptionResponse = new ExceptionResponse("Validation Failure", allErrors.toString());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ExceptionResponse> handleGeneralException(GeneralException ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_GATEWAY);
    }
}
