package com.teamStocker.domain.user.domain;

import com.teamStocker.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_tbl")
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder
    public User (String profileImg, String name, String nickName, String email, String password) {
        this.profileImg = profileImg;
        this.name = name;
        this.nickName =  nickName;
        this.email = email;
        this.password = password;
    }
}
