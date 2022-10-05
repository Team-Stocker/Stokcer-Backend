package com.teamStocker.domain.diary.domain.repository;

import com.teamStocker.domain.diary.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
