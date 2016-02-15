package com.intelligrape.dao;

import com.intelligrape.model.Subscription;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.model.UserRole;
import com.intelligrape.service.UtilService;
import com.intelligrape.util.Util;
import com.intelligrape.util.enums.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.Predicate;
import java.util.Date;
import java.util.List;

@Repository("userDao")
@Component
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Autowired
    public ApplicationContext applicationContext;


    public UtilService getUtilService() {
        return (UtilService) applicationContext.getBean("utilService");
    }

    public User findById(int id) {
        return getByKey(id);
    }

    public User saveEmployee(User user) {
        return (User) save(user);
    }

    @Transactional
    public User saveEmployeeAndRole(User employee, String role) {
        User user = saveEmployee(employee);
        getSession().save(new UserRole(employee, role));
        return user;
    }

    public List<User> findAllUser() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public Long countUserTopics(User user) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Topic.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.setProjection(Projections.count("id"));
        return (Long) criteria.list().get(0);
    }

    public Long countSubscribedTopics(User user) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.setProjection(Projections.count("id"));
        return (((Long) criteria.list().get(0)) - countUserTopics(user));
    }

    public Long countUnSubscribedTopics(User user) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Subscription.class);
        criteria.add(Restrictions.ne("user", user));
        criteria.setProjection(Projections.count("id"));
        return (Long) criteria.list().get(0);
    }

    public Long countTopicsSubscribedToday(User user) {
        Criteria criteria = sessionFactory.openSession().createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.createAlias("topic","subscriptionTopic");
        criteria.add(Restrictions.between("dateCreated", Util.clearTime(new Date()),new Date()));
        criteria.add(Restrictions.ne("subscriptionTopic.user",user));
        criteria.setProjection(Projections.count("id"));
        return (Long) criteria.list().get(0);
    }
}
