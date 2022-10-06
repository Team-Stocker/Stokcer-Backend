package com.teamStocker.domain.diary.domain.repository;

import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.diary.domain.type.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findAllByCategory(Category category);

    @Query("SELECT d FROM Diary d ORDER BY d.likes.size DESC")
    List<Diary> findGreatestDiary();
}
