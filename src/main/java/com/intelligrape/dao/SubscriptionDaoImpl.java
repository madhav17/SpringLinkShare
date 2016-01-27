package com.intelligrape.dao;

import com.intelligrape.model.Subscription;
import org.hibernate.Criteria;

import java.util.List;

public class SubscriptionDaoImpl extends AbstractDao<Integer, Subscription> implements SubscriptionDao {

    public Subscription findById(int id) {
        return getByKey(id);
    }

    public void saveSubscription(Subscription subscription) {
        save(subscription);
    }

    public List<Subscription> findAllSubscription() {
        Criteria criteria = createEntityCriteria();
        return (List<Subscription>) criteria.list();
    }

}
