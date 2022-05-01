package com.omarox.vspring.dao;

import java.util.List;

import com.omarox.vspring.model.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> findByTopicId(String topicId);

}
