package com.intelligrape.service;

import com.intelligrape.dao.SubscriptionDao;
import com.intelligrape.model.Subscription;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import org.apache.commons.collections.ListUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("subscriptionService")
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    public SubscriptionDao subscriptionDao;

    @Autowired
    public TopicService topicService;

    @Autowired
    public UserService userService;

    public Subscription findById(int id) {
        return subscriptionDao.findById(id);
    }

    @Transactional
    public void saveSubscription(Subscription subscription) {
        subscriptionDao.saveSubscription(subscription);
    }

    @Transactional
    public void createSubscription(User user, Topic topic, Date dateCreated) {
        Subscription subscription = new Subscription(user, topic, dateCreated);
        saveSubscription(subscription);
    }

    @Transactional
    public void deleteSubscription(Subscription subscription) {
        subscriptionDao.deleteSubscription(subscription);
    }

    @Transactional
    public void deleteSubscription(int id) {
        subscriptionDao.deleteSubscription(id);
    }


    @Transactional
    public void updateSubscription(Subscription subscription, User user, Topic topic, Date dateCreated) {

    }

    public List<Subscription> findAllSubscription() {
        return subscriptionDao.findAllSubscription();
    }

    @Transactional
    public void deleteSubscription(User user, Topic topic) {

        Criteria criteria = subscriptionDao.fetchCriteria();
        criteria.add(Restrictions.eq("topic", topic));
        criteria.add(Restrictions.eq("user", user));
        Subscription subscription = (Subscription) criteria.uniqueResult();
        deleteSubscription(subscription);
    }

    @Transactional
    public List<Topic> fetchUnSubscribedTopics(User user) {

        List<Topic> allTopics = topicService.findAllTopics();
        List<Topic> userTopics = userService.findAllUserTopics(user);
        List<Topic> subscribedTopics = fetchSubscribedTopics(user);
        allTopics = ListUtils.removeAll(allTopics,userTopics);
        allTopics = ListUtils.removeAll(allTopics,subscribedTopics);
        return allTopics;
    }

    @Transactional
    public List<Topic> fetchSubscribedTopics(User user) {
        Criteria criteria = subscriptionDao.fetchCriteria();
        criteria.add(Restrictions.eq("user", user));
        criteria.setProjection(Projections.property("topic"));
        List<Topic> topicList = (List<Topic>) criteria.list();
        topicList = ListUtils.removeAll(topicList,userService.findAllUserTopics(user));
        return topicList;
    }

}
