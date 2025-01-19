package com.haryodsanotes.bfsdfs.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ReturnedExceptionHandler {
    @ExceptionHandler(MatrixDimensionException.class)
    public ResponseEntity<String> handleMatrixDimensionException(MatrixDimensionException ex) {
        log.warn("Invalid matrix dimension");
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
