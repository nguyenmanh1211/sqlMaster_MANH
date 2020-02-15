package com.nguyenducmanh.controller;

import com.nguyenducmanh.entity.Databases;
import com.nguyenducmanh.entity.Lesson;
import com.nguyenducmanh.model.request.DatabaseRequest;
import com.nguyenducmanh.service.IDatabaseService;
import com.nguyenducmanh.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private ILessonService lessonService;

    private IDatabaseService databaseService;

    @Autowired
    public AdminController(ILessonService lessonService, IDatabaseService databaseService) {
        this.lessonService = lessonService;
        this.databaseService = databaseService;
    }

    @GetMapping("/home")
    public ModelAndView adminHome(){
        return  new ModelAndView("home-admin");
    }

    @GetMapping("/databases")
    public ModelAndView dataTable(@RequestParam(value = "databaseName") String databaseName){
        ModelAndView mav =new ModelAndView("data-table");
        List<Lesson> lessons= lessonService.findLessonByDatabases(databaseName);
        mav.addObject("lessons",lessons);
        mav.addObject("databaseName",databaseName);
        return mav;
    }

    @GetMapping("/database")
    public ModelAndView findAllDatabase(){
        ModelAndView mav = new ModelAndView("database-manager");
        List<Databases> list = databaseService.findAll();
        mav.addObject("list",list);
        return mav;
    }
    @GetMapping("/createDBpage")
    public ModelAndView createDBpage(){
        return new ModelAndView("create-database");
    }

    @GetMapping("/updateDBpage")
    public ModelAndView updateDBpage(@RequestParam long id,@RequestParam String name){
        ModelAndView mav = new ModelAndView("create-database");
        mav.addObject("id",id);
        mav.addObject("name",name);
        return mav;
    }
}
