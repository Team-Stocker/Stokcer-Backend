package com.teamStocker.domain.user.exception;

import com.teamStocker.global.error.exception.BusinessException;
import com.teamStocker.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {

    public static final PasswordMismatchException EXCEPTION = new PasswordMismatchException();

    private PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
