package com.nguyenducmanh.controller;

import com.nguyenducmanh.entity.Lesson;
import com.nguyenducmanh.model.request.LessonRequest;
import com.nguyenducmanh.service.IDatabaseService;
import com.nguyenducmanh.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLessonController {

    private ILessonService lessonService;
    private IDatabaseService databaseService;

    @Autowired
    public AdminLessonController(ILessonService lessonService,IDatabaseService databaseService) {
        this.lessonService = lessonService;
        this.databaseService = databaseService;
    }

    @RequestMapping(value = "/insertLesson")
    public String insertLesson(@ModelAttribute(value = "lesson") LessonRequest lessonRequest) {
        lessonService.insert(lessonRequest);
        String url = "?id="+lessonRequest.getDatabaseID();
        return "redirect:/admin/createLSpage"+url;
    }
    @RequestMapping(value = "/updateLesson")
    public String updateLesson(@ModelAttribute(value = "lesson") LessonRequest lessonRequest){
        lessonService.update(lessonRequest,lessonRequest.getId());
        Lesson lesson = lessonService.findOne(lessonRequest.getId());
        String url = "?databaseName="+lesson.getDatabases().getName();
        return "redirect:/admin/databases"+url;
    }
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String updateLesson(@RequestParam long id){
        Lesson lesson = lessonService.findOne(id);
        String x = "?databaseName="+lesson.getDatabases().getName();
        lessonService.delete(id);
        return "redirect:/admin/databases"+x;
    }
}
