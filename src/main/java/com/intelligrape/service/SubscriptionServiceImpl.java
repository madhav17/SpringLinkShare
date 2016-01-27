package com.intelligrape.service;

import com.intelligrape.dao.SubscriptionDao;
import com.intelligrape.model.Subscription;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service("subscriptionService")
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    public SubscriptionDao subscriptionDao;

    public Subscription findById(int id) {
        return subscriptionDao.findById(id);
    }

    @Transactional
    public void saveSubscription(Subscription subscription) {
        subscriptionDao.saveSubscription(subscription);
    }

    @Transactional
    public void createSubscription(User user,Topic topic,Date dateCreated){
        Subscription subscription = new Subscription(user,topic,dateCreated);
        saveSubscription(subscription);
    }

    @Transactional
    public void deleteSubscription(Subscription subscription){
       subscriptionDao.deleteSubscription(subscription);
    }

    @Transactional
    public void deleteSubscription(int id){
        subscriptionDao.deleteSubscription(id);
    }


    @Transactional
    public void updateSubscription(Subscription subscription,User user,Topic topic,Date dateCreated){

    }

    public List<Subscription> findAllSubscription(){
        return subscriptionDao.findAllSubscription();
    }

}
