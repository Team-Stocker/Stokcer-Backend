package com.teamStocker.global.security.jwt.exception;

import com.teamStocker.global.error.exception.BusinessException;
import com.teamStocker.global.error.exception.ErrorCode;

public class AlreadyLogoutException extends BusinessException {

    public final static AlreadyLogoutException EXCEPTION = new AlreadyLogoutException();

    private AlreadyLogoutException() {
        super(ErrorCode.ALREADY_LOGOUT);
    }
}
