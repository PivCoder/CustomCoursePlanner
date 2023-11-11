package com.example.customcourseplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursePlannerController {
    @GetMapping("/CoursePlanner")
    public String showCoursePlanner(){
        return "templates/index.html";
    }
}
