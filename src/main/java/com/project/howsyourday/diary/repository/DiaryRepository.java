package com.project.howsyourday.diary.repository;

import com.project.howsyourday.diary.model.Diary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
//    @Query("SELECT d FROM Diary d WHERE d.title LIKE %?1%")
//    List<Diary> findByTitleLike(String title);

    @Query
    List<Diary> findByTitleLike(String title);
}
