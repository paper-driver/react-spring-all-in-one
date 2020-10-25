package com.allinone.reactspring.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMessage<T> {
    String email;
    T request;

    RequestMessage(String email){
        email = email;
    }

    RequestMessage(String email, T request){
        email = email;
        request= request;
    }
}
