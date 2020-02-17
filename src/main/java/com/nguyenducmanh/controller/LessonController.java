package com.nguyenducmanh.controller;

import com.nguyenducmanh.entity.Lesson;
import com.nguyenducmanh.service.IDatabaseService;
import com.nguyenducmanh.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class LessonController {

    private ILessonService iLessonService;
    private IDatabaseService databaseService;

    @Autowired
    public LessonController(ILessonService iLessonService,IDatabaseService databaseService) {
        this.iLessonService = iLessonService;
        this.databaseService = databaseService;
    }

    @RequestMapping(value = "/database", method = RequestMethod.GET)
    public ModelAndView findLessonByDatabase(@RequestParam String databaseName) {
        ModelAndView mav = new ModelAndView("database");
        List<Lesson> lessons = iLessonService.findLessonByDatabases(databaseName);
        mav.addObject("lessons", lessons);
        return mav;
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public Lesson getLesson(@RequestParam(value = "id") Long id) {
        Lesson lessonProperties = iLessonService.findOne(id);
        return lessonProperties;
    }

    @RequestMapping(value = "/apix", method = RequestMethod.GET)
    public List<Lesson> getLessonByDatabase(@RequestParam(value = "databaseName") String databaseName) {
        List<Lesson> lessons = iLessonService.findLessonByDatabases(databaseName);
        return lessons;
    }



}
