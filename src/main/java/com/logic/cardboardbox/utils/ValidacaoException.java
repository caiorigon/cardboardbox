package com.logic.cardboardbox.utils;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ValidacaoException extends RuntimeException {
    private String erro;
    private HttpStatus status;

    public ValidacaoException(String erro) {
        this.erro = erro;
    }

    public ValidacaoException() {
    }

    public String getErro() {
        return erro;
    }

    public ValidacaoException setErro(String erro) {
        this.erro = erro;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ValidacaoException setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }
}
