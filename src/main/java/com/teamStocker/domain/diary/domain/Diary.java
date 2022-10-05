package com.teamStocker.domain.diary.domain;

import com.teamStocker.domain.diary.domain.type.Category;
import com.teamStocker.domain.user.domain.User;
import com.teamStocker.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "diary_tbl")
public class Diary extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long id;

    private String title;

    private String content;

    private Category category;

    private int rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Diary(String title, String content, Category category, int rate) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.rate = rate;
    }

    public Diary setRelation(User user) {
        this.user = user;
        user.getDiaries().add(this);
        return this;
    }

    public void update(String title, String content, Category category, int rate) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.rate = rate;
    }
}