package com.nguyenducmanh.service.impl;

import com.nguyenducmanh.entity.Databases;
import com.nguyenducmanh.entity.Lesson;
import com.nguyenducmanh.repository.DatabasesRepository;
import com.nguyenducmanh.repository.LessonRepository;
import com.nguyenducmanh.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService implements ILessonService {


    private LessonRepository lessonRepository;
    private DatabasesRepository databasesRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository, DatabasesRepository databasesRepository) {
        this.lessonRepository = lessonRepository;
        this.databasesRepository = databasesRepository;
    }

    @Override
    public List<Lesson> findLessonByDatabases(String databaseName) {
        Databases databases= databasesRepository.findDatabasesByName(databaseName);
        List<Lesson> lessons = lessonRepository.findLessonByDatabases(databases);

        return lessons;
    }

    @Override
    public Lesson findOne(long id) {
        return lessonRepository.findOne(id);
    }
}
