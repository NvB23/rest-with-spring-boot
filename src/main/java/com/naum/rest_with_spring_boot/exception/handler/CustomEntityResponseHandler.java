package com.naum.rest_with_spring_boot.exeption.handler;

import com.naum.rest_with_spring_boot.exeption.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {
    public final ResponseEntity<ExceptionResponse> handleAllException
}
