package com.invoicecore.item.invoicecore.item.configuration;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InvocationTargetException.class, NoSuchElementException.class})
    protected ResponseEntity<Object> handleNoTFound(RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, "algo paso", new HttpHeaders(), HttpStatus.NO_CONTENT, request);

    }



}

