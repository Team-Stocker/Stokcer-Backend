package com.teamStocker.domain.user.exception;

import com.teamStocker.global.error.exception.BusinessException;
import com.teamStocker.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends BusinessException {

    public final static UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
