package com.omarox.vspring.service;

import java.util.Arrays;
import java.util.List;

import com.omarox.vspring.model.Topic;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description"));

    public List<Topic> getAllTopics() {
        return topics;
    }
}
