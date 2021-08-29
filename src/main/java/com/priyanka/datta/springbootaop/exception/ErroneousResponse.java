package com.priyanka.datta.springbootaop.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroneousResponse {

    private String responseCode;

    private String responseMessage;
}
