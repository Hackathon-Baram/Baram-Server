package com.hackathon.baram.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseData<T> extends Response {

    public T data;

    public ResponseData(HttpStatus httpStatus, String message, T data) {
        super(httpStatus, message);
        this.data = data;
    }
}
