package com.omarox.vspring.controller;

import java.util.List;

import com.omarox.vspring.model.Course;
import com.omarox.vspring.model.Topic;
import com.omarox.vspring.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String topicId, @PathVariable String id) {
        return courseService.getCourse(id).orElse(null);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(
            @PathVariable String topicId,
            @PathVariable String id,
            @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String topicId, @PathVariable String id) {
        courseService.deleteCourse(id);
    }

}
