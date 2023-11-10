package com.example.customcourseplanner.rest;

import com.example.customcourseplanner.exceptions.ElementNotFoundException;
import com.example.customcourseplanner.model.Course;
import com.example.customcourseplanner.service.CourseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CourseRestController {

    private final CourseServiceImpl courseService;

    CourseRestController(CourseServiceImpl courseService){
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    List<Course> getAll(){
        return courseService.getAllCourses();
    }

    @GetMapping("/courses{id}")
    Course getById(@PathVariable Long id){
        return courseService.getCourseById(id).orElseThrow(ElementNotFoundException::new);
    }

    @PutMapping("/courses{id}")
    Course edit(@RequestBody Course course, @PathVariable Long id){
        return courseService.editCourse(course, id);
    }

    @PostMapping("/courses")
    Course create(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @DeleteMapping("/courses{id}")
    void delete(@PathVariable Long id){
        courseService.deleteCourseById(id);
    }
}
