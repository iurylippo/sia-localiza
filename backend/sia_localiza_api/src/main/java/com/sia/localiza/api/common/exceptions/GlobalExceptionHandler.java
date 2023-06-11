package com.sia.localiza.api.common.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.sia.localiza.api.modules.auth.exceptions.UnauthorizedException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler implements ErrorController {

        @ExceptionHandler({ ValidationException.class })
        public ResponseEntity<ApiError> validationException(
                        ValidationException ex,
                        HttpServletRequest request) {
                log.error("validation exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Request is not valid: " + ex.getLocalizedMessage())
                                                .status_code(HttpStatus.BAD_REQUEST.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler({ UnauthorizedException.class })
        public ResponseEntity<ApiError> noSuchElementException(
                        UnauthorizedException ex,
                        HttpServletRequest request) {

                log.error("Unauthorized exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Unauthorized!")
                                                .status_code(HttpStatus.UNAUTHORIZED.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.UNAUTHORIZED);
        }

        @ExceptionHandler({ ExpiredJwtException.class })
        public ResponseEntity<ApiError> noSuchElementException(
                        ExpiredJwtException ex,
                        HttpServletRequest request) {

                log.error("expired jwt exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Token Expired!")
                                                .status_code(HttpStatus.UNAUTHORIZED.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.UNAUTHORIZED);
        }

        @ExceptionHandler({ UnsupportedJwtException.class })
        public ResponseEntity<ApiError> noSuchElementException(
                        UnsupportedJwtException ex,
                        HttpServletRequest request) {

                log.error("unsupported jwt exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Token Unsupported!")
                                                .status_code(HttpStatus.UNAUTHORIZED.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.UNAUTHORIZED);
        }

        @ExceptionHandler({ MalformedJwtException.class })
        public ResponseEntity<ApiError> noSuchElementException(
                        MalformedJwtException ex,
                        HttpServletRequest request) {

                log.error("Malformed jwt exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Token Malformed!")
                                                .status_code(HttpStatus.UNAUTHORIZED.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.UNAUTHORIZED);
        }

        @ExceptionHandler({ SignatureException.class })
        public ResponseEntity<ApiError> noSuchElementException(
                        SignatureException ex,
                        HttpServletRequest request) {

                log.error("Signature jwt exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Invalid Token Signature!")
                                                .status_code(HttpStatus.UNAUTHORIZED.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.UNAUTHORIZED);
        }

        @ExceptionHandler({ BadRequestException.class, BadRequest.class })
        public ResponseEntity<ApiError> noSuchElementException(
                        Throwable ex,
                        HttpServletRequest request) {

                log.error("BadRequestException : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message(ex.getLocalizedMessage())
                                                .status_code(HttpStatus.BAD_REQUEST.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler({ EntityNotFoundException.class, })
        public ResponseEntity<ApiError> noSuchElementException(
                        EntityNotFoundException ex,
                        HttpServletRequest request) {

                log.error("EntityNotFoundException : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Entity not found!")
                                                .status_code(HttpStatus.NOT_FOUND.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler({ NoSuchElementException.class })
        public ResponseEntity<ApiError> noSuchElementException(
                        NoSuchElementException ex,
                        HttpServletRequest request) {

                log.error("validation exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Entity not found!")
                                                .status_code(HttpStatus.NOT_FOUND.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler({ MethodArgumentNotValidException.class })
        public ResponseEntity<ApiError> invalidJsonArgument(
                        MethodArgumentNotValidException ex,
                        HttpServletRequest request) {

                log.error("schema validation exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                Map<String, String> errors = new HashMap<>();

                ex.getBindingResult().getAllErrors().forEach((error -> {
                        String fieldName = ((FieldError) error).getField();
                        String errorMessage = error.getDefaultMessage();

                        errors.put(fieldName, errorMessage);
                }));

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Schema validation error!")
                                                .status_code(HttpStatus.UNPROCESSABLE_ENTITY.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .errors(errors)
                                                .build(),
                                HttpStatus.UNPROCESSABLE_ENTITY);
        }

        @ExceptionHandler({ HttpMessageNotReadableException.class })
        public ResponseEntity<ApiError> invalidJsonArgument(
                        HttpMessageNotReadableException ex,
                        HttpServletRequest request) {

                log.error("schema validation exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                Map<String, String> errors = new HashMap<>();

                errors.put("enum", ex.getLocalizedMessage());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Schema validation error!")
                                                .status_code(HttpStatus.UNPROCESSABLE_ENTITY.value())
                                                .request(request.getRequestURI())
                                                .method(request.getMethod())
                                                .errors(errors)
                                                .build(),
                                HttpStatus.UNPROCESSABLE_ENTITY);

        }

        @ExceptionHandler({ Throwable.class })
        public ResponseEntity<ApiError> genericException(
                        Throwable ex,
                        HttpServletRequest request) {

                log.error("exception : " +
                                ex.getLocalizedMessage() +
                                " for " +
                                request.getRequestURI());

                return new ResponseEntity<>(
                                ApiError.builder()
                                                .message("Could not process request: " + ex.getLocalizedMessage())
                                                .status_code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                                .request(request.getRequestURI())
                                                .exception(ex.getClass().getName())
                                                .method(request.getMethod())
                                                .build(),
                                HttpStatus.INTERNAL_SERVER_ERROR);
        }

}