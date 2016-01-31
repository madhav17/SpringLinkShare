package com.intelligrape.service;

import com.intelligrape.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {


    @Autowired
    public SessionFactory sessionFactory;

    @Autowired
    public MailHelperService mailHelperService;

    @Transactional
    public List<User> getUser(String username, String password) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password));
        return criteria.list();
    }

    public String sendPassword(String username) {
        String msg = null;
        String password = getPassword(username);
        if (password != null) {
            mailHelperService.sendMail(username, "Forgot Password", "Hello, Your Password is " + password + " .");
            msg = "Password is send to Registered Email ID";
        } else {
            msg = "Username is not Registered";
        }
        return msg;
    }

    public String getPassword(String username) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.setProjection(Projections.property("password"));
        return (String) criteria.uniqueResult();
    }
}
