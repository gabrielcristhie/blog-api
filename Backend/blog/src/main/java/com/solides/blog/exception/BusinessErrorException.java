package com.solides.blog.exception;

import com.solides.blog.domain.enums.Errors;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
public class BusinessErrorException extends RuntimeException implements Serializable {

    public final static long seriaVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public BusinessErrorException(Errors tabelErrors) {
        this.message = tabelErrors.getMessage();
        this.httpStatus = tabelErrors.getHttpStatus();
    }
}
