package org.gaborbalazs.kipchakify.web.exception;

import java.time.ZonedDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice(basePackages = {"org.gaborbalazs.kipchakify"})
class RestResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IllegalArgumentException.class)
    ExceptionResponse handleIllegalArgumentException(Exception exception, WebRequest request) {
        return createExceptionResponse(exception, request);
    }

    private ExceptionResponse createExceptionResponse(Exception exception, WebRequest request) {
        return ExceptionResponse.newBuilder()
                .withTimestamp(ZonedDateTime.now())
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .withMessage(exception.getMessage())
                .withPath(((HttpServletRequest) request).getRequestURI())
                .build();
    }
}
