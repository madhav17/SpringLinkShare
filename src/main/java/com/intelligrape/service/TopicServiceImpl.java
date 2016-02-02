package com.intelligrape.service;

import com.intelligrape.dao.SubscriptionDao;
import com.intelligrape.dao.TopicDao;
import com.intelligrape.model.Subscription;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("topicService")
@Transactional
public class TopicServiceImpl implements TopicService {


    @Autowired
    public TopicDao topicDao;

    @Autowired
    public SubscriptionDao subscriptionDao;

    public Topic findById(int id) {
        return topicDao.findById(id);
    }

    @Transactional
    public Topic saveTopic(Topic topic) {
        return topicDao.saveTopic(topic);
    }

    @Transactional
    public void saveTopicCreateSubscription(Topic topic,User user){
        saveTopic(topic);
        Subscription subscription = new Subscription(user,topic,new Date());
        subscriptionDao.saveSubscription(subscription);
    }

    @Transactional
    public void updateTopic(Topic topic,String title,String link){
        Topic entity = topicDao.findById(topic.id);
        if(entity!=null){
            entity.title = title;
            entity.link = link;
            topicDao.saveTopic(entity);
        }
    }

    public List<Topic> findAllTopics(){
        return topicDao.findAllTopic();
    }
}
