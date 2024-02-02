package com.solides.blog.domain.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Errors {

    POST_NOT_FOUND("Promocao não encontrada", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND("Usuário não encontrado", HttpStatus.NOT_FOUND),
    COMMENT_NOT_FOUND("Comentário não encontrado", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;

    Errors(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}