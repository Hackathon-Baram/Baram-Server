package com.hackathon.baram.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    public int status;
    public String message;

    public Response(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }
}

