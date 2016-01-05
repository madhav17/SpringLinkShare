package com.intelligrape.service;

import com.intelligrape.model.Topic;

import java.util.List;

public interface TopicService {


    Topic findById(int id);

    void saveTopic(Topic topic);

    void updateTopic(Topic topic, String title);

    List<Topic> findAllTopics();
}
