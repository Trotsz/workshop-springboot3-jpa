package com.pursuit.springclass.resources.exceptions;

import com.pursuit.springclass.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String err = "Resource not Found.";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError stdError = new StandardError(Instant.now(), httpStatus.value(), e.getMessage(), err, request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(stdError);
    }
}
