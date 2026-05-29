package com.parking.infrastructure.controller;

import com.parking.crosscuting.exception.BusinessException;
import com.parking.crosscuting.messagescatalog.MessagesEnum;
import com.parking.infrastructure.rest.dto.ErrorResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(
            final MethodArgumentNotValidException ex) {

        final String enumKey = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getDefaultMessage())
                .orElse(MessagesEnum.GENERAL_UNEXPECTED_ERROR.name());

        final MessagesEnum message = resolveMessage(enumKey);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(
                        message.getTitle(),
                        message.getContent(),
                        HttpStatus.BAD_REQUEST.value()
                ));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessError(
            final BusinessException ex) {

        final MessagesEnum message = ex.getMessagesEnum();

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        message.getTitle(),
                        message.getContent(),
                        HttpStatus.CONFLICT.value()
                ));
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleDomainInvariantError(
            final IllegalArgumentException ex) {

        final MessagesEnum message = resolveMessage(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_CONTENT)
                .body(new ErrorResponse(
                        message.getTitle(),
                        message.getContent(),
                        HttpStatus.UNPROCESSABLE_CONTENT.value()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedError(
            final Exception ex) {
    	
    	log.error("Error inesperado capturado: ", ex);

        final MessagesEnum message = MessagesEnum.GENERAL_UNEXPECTED_ERROR;

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(
                        message.getTitle(),
                        message.getContent(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value()
                ));
    }

    private MessagesEnum resolveMessage(final String key) {
        try {
            return MessagesEnum.valueOf(key);
        } catch (IllegalArgumentException | NullPointerException _) {
            return MessagesEnum.GENERAL_UNEXPECTED_ERROR;
        }
    }
}