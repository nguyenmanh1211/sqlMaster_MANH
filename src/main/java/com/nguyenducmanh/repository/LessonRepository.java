package com.nguyenducmanh.repository;

import com.nguyenducmanh.entity.Databases;
import com.nguyenducmanh.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
    @Query("SELECT l from Lesson l where l.databases = :database ORDER BY l.id ASC ")
    List<Lesson> findLessonByDatabases(@Param("database") Databases database);

    @Query("select  l from Lesson l where l.id=:id")
    Lesson findLessonByName_lesson(@Param("id") Long id);
}
