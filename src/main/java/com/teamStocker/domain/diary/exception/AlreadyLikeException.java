package com.teamStocker.domain.diary.exception;

import com.teamStocker.global.error.exception.BusinessException;
import com.teamStocker.global.error.exception.ErrorCode;

public class AlreadyLikeException extends BusinessException {

    public final static AlreadyLikeException EXCEPTION = new AlreadyLikeException();

    private AlreadyLikeException() {
        super(ErrorCode.ALREADY_LIKE);
    }
}
