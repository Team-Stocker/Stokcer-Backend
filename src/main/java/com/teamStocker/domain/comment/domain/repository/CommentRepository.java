package com.teamStocker.domain.comment.domain.repository;

import com.teamStocker.domain.comment.domain.Comment;
import com.teamStocker.domain.diary.domain.Diary;
import com.teamStocker.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByDiary(Diary diary);
}
