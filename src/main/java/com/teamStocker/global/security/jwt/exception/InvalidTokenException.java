package com.teamStocker.global.security.jwt.exception;

import com.teamStocker.global.error.exception.BusinessException;
import com.teamStocker.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public static final InvalidTokenException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
