package com.intelligrape.service;

import com.intelligrape.model.Subscription;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;

import java.util.Date;
import java.util.List;

public interface SubscriptionService {


    Subscription findById(int id);

    void saveSubscription(Subscription subscription);

    void updateSubscription(Subscription subscription, User user,Topic topic,Date dateCreated);

    List<Subscription> findAllSubscription();
}
