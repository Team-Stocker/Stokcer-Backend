package com.teamStocker.domain.user.domain;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.Like;
import com.teamStocker.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_tbl")
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(nullable = false)
    private String name;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Diary> diaries = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @Builder
    public User (String profileImg, String name, String nickName, String email, String password) {
        this.profileImg = profileImg;
        this.name = name;
        this.nickName =  nickName;
        this.email = email;
        this.password = password;
    }
}
