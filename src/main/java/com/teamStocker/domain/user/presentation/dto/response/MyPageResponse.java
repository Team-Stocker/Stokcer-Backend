package com.teamStocker.domain.user.presentation.dto.response;

import com.teamStocker.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyPageResponse {

    private String nickName;
    private int numberOfDiary;
    private String profileImg;

    public static MyPageResponse of (User user) {
        return MyPageResponse.builder()
                .nickName(user.getNickName())
                .numberOfDiary(user.getDiaries().size())
                .profileImg(user.getProfileImg())
                .build();
    }
}
