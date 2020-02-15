package com.nguyenducmanh.controller;

import com.nguyenducmanh.model.request.DatabaseRequest;
import com.nguyenducmanh.service.IDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class DatabaseController {
    private IDatabaseService databaseService;

    @Autowired
    public DatabaseController(IDatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insertDatabase(@ModelAttribute(value = "database") @RequestBody DatabaseRequest databaseRequest){
        databaseService.insert(databaseRequest);
        return "redirect:/admin/database";
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable long id){
        databaseService.delete(id);
        return "redirect:/admin/database";
    }
    @RequestMapping(value = "/update")
    public String update(@ModelAttribute(value = "database") @RequestBody DatabaseRequest databaseRequest){
        databaseService.update(databaseRequest,databaseRequest.getId());
        return "redirect:/admin/database";
    }
}
