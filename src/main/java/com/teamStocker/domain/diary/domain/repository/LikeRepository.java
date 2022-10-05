package com.teamStocker.domain.diary.domain.repository;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.Like;
import com.teamStocker.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByUserAndDiary(User user, Diary diary);

    void deleteByUserAndDiary(User user, Diary diary);
}
