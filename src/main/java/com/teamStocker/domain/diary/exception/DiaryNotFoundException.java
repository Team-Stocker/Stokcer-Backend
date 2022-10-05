package com.teamStocker.domain.diary.exception;

import com.teamStocker.global.error.exception.BusinessException;
import com.teamStocker.global.error.exception.ErrorCode;

public class DiaryNotFoundException extends BusinessException {

    public static final DiaryNotFoundException EXCEPTION = new DiaryNotFoundException();

    private DiaryNotFoundException() {
        super(ErrorCode.DIARY_NOT_FOUND);
    }
}
