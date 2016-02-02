package com.intelligrape.dao;


import com.intelligrape.model.Topic;

import java.util.List;

public interface TopicDao {

    Topic findById(int id);

    Topic saveTopic(Topic employee);

    List<Topic> findAllTopic();
}
