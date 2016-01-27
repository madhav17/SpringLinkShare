package com.intelligrape.dao;

import com.intelligrape.model.Subscription;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("subscriptionDao")
@Component
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
