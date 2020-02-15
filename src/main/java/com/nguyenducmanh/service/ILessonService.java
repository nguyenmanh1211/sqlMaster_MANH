package com.nguyenducmanh.service;

import com.nguyenducmanh.entity.Lesson;

import java.util.List;

public interface ILessonService {
    List<Lesson> findLessonByDatabases(String databaseId);
    Lesson findOne(long id);
}
