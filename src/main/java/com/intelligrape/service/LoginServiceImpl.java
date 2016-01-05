package com.intelligrape.service;

import com.intelligrape.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {


    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<User> getUser(String userName, String password) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("password", password));
        return criteria.list();
    }
}
