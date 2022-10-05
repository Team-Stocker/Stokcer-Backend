package com.teamStocker.global.security.jwt.exception;

import com.teamStocker.global.error.exception.BusinessException;
import com.teamStocker.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {

    public final static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
