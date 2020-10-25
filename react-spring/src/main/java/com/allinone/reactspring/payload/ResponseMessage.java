package com.allinone.reactspring.payload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseMessage<T> {

    private String message;
    private HttpStatus status;
    private T object;

    public ResponseMessage() {}

    public ResponseMessage(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }

    public ResponseMessage(String message, HttpStatus status, T object){
        this.message = message;
        this.status = status;
        this.object = object;
    }
}
