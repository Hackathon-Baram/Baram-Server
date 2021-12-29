package com.hackathon.baram.domain.handler;


import com.hackathon.baram.domain.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Response> handleHttpClientException(HttpClientErrorException e) {
        Response response = new Response(e.getStatusCode(), e.getMessage().substring(4));
        return new ResponseEntity<>(response, e.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception e) {
        e.printStackTrace();
        Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}