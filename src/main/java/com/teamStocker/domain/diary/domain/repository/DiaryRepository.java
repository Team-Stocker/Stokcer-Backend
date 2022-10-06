package com.teamStocker.domain.diary.domain.repository;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.type.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findAllByCategory(Category category);
}
