package com.intelligrape.dao;

import com.intelligrape.model.Subscription;
import com.intelligrape.model.Topic;

import java.util.List;

public interface SubscriptionDao {

    Subscription findById(int id);

    void saveSubscription(Subscription subscription);

    List<Subscription> findAllSubscription();
}
