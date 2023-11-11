package com.example.customcourseplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CoursePlannerController {
    @GetMapping("/CoursePlanner")
    public String showCoursePlanner(){
        return "index";
    }
}
