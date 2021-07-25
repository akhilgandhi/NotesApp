package com.notes.notesapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({NoteNotFoundException.class})
    public ResponseEntity<ExceptionResponseMessage> handleControllerExceptionNotFound(final HttpServletRequest request,
                                                                                      final Throwable ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(ExceptionResponseMessage.builder().message(ex.getMessage()).build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptionResponseMessage> handleGenericException(final HttpServletRequest request,
                                                                           final Throwable ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(ExceptionResponseMessage.builder().message("some error occurred.").build());
    }
}
