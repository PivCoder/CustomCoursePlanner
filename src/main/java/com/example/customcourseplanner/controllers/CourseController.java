package com.example.customcourseplanner.controllers;

import com.example.customcourseplanner.model.Course;
import com.example.customcourseplanner.service.CourseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {
    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String showCourses(Model model){
        List<Course> courseList = courseService.getAllCourses();
        model.addAttribute("courseList", courseList);
        return "courses";
    }

    @GetMapping("/courses/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        Optional<Course> course = courseService.getCourseById(id);
        List<Course> courseList = new ArrayList<>();
        course.ifPresent(courseList::add);
        model.addAttribute("courseList", courseList);
        return "courses"; //TODO используем одну и ту же страницу с разными параметрами
    }

    @GetMapping("/new_course")
    public String addCourse(){
        return "/newCourse";
    }

    @PostMapping("/new_course")
    public String coursePostAdd(@RequestBody Course course){
        courseService.addCourse(course); //TODO скорее всего некорректно
        return "redirect:/courses";
    }

    @GetMapping("/courses/{id}/edit")
    public String editCourse(@PathVariable("id") long id, Model model) {
        Optional<Course> course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "editCourse";
    }

    @PostMapping("/courses/{id}/edit")
    public String coursePostEdit(@PathVariable("id") long id, @ModelAttribute Course course) {
        courseService.editCourse(course, id);
        return "redirect:/courses";
    }

    @PostMapping("/courses/{id}/delete")
    public String coursePostDelete(@PathVariable long id) {
        courseService.deleteCourseById(id);
        return "redirect:/courses";
    }
}
