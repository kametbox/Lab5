package study.stepup.lesson5.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import study.stepup.lesson5.model.response.ResponseError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({HttpClientErrorException.class})
    protected ResponseEntity<ResponseError> handleHttpClientError(HttpClientErrorException ex) {
        return new ResponseEntity<>(new ResponseError(ex.getStatusCode(), ex), ex.getStatusCode());
    }
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ResponseError> handleException(Exception ex) {
        return new ResponseEntity<>(new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR, ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}