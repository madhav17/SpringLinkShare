package com.intelligrape.service;

import com.intelligrape.dao.TopicDao;
import com.intelligrape.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("topicService")
@Transactional
public class TopicServiceImpl implements TopicService {


    @Autowired
    public TopicDao topicDao;

    public Topic findById(int id) {
        return topicDao.findById(id);
    }

    @Transactional
    public void saveTopic(Topic topic) {
        topicDao.saveTopic(topic);
    }

    @Transactional
    public void updateTopic(Topic topic,String title){
        Topic entity = topicDao.findById(topic.id);
        if(entity!=null){
            entity.title = title;
            topicDao.saveTopic(entity);
        }
    }

    public List<Topic> findAllTopics(){
        return topicDao.findAllTopic();
    }
}
