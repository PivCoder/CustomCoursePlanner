package com.example.customcourseplanner.service.api;

import com.example.customcourseplanner.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course addCourse(Course course);
    void deleteCourseById(long id);
    Optional<Course> getCourseById(long id);
    Course editCourse(Course course);
    List<Course> getAllCourses();
}
