package com.example.customcourseplanner.service;

import com.example.customcourseplanner.model.Course;
import com.example.customcourseplanner.repositoryes.CourseRepository;
import com.example.customcourseplanner.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> getCourseById(long id) {
        return courseRepository.findById(id);
    }

    //TODO не уверен в правильности
    @Override
    public Course editCourse(Course newCourse, long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(course.getName());
                    course.setDescription(course.getDescription());
                    course.setMaterials(course.getMaterials()); //особенно тут
                    course.setTaskList(course.getTaskList()); //и тут
                    return courseRepository.save(course);
                })
                .orElseGet(() -> courseRepository.save(newCourse));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
