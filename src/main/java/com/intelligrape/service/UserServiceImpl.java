package com.intelligrape.service;

import com.intelligrape.dao.UserDao;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.util.enums.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public SessionFactory sessionFactory;

    public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public User findById(int id) {
        log.error("dsfdsfdsfdsfdsfdsfdsf");
        return userDao.findById(id);
    }

    @Transactional
    public User saveUser(User user) {
        return userDao.saveEmployee(user);
    }

    @Transactional
    public void updateUser(User user, String firstName, String lastName, String password) {
        User entity = userDao.findById(user.id);
        if (entity != null) {
            entity.firstName = firstName;
            entity.lastName = lastName;
            entity.password = password;
            userDao.saveEmployee(entity);
        }
    }

    public List<User> findAllUsers() {
        return userDao.findAllUser();
    }

    @Transactional
    public List<Topic> findAllUserTopics(User user) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Topic.class);
        criteria.add(Restrictions.eq("user", user));
        return criteria.list();
    }

    @Transactional
    public User saveUserAndRole(User employee,String role){
        return userDao.saveEmployeeAndRole(employee,role);
    }

    public User findByUsername(String username){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username",username));
        return (User)criteria.uniqueResult();
    }

    public User getLoggedInUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            //UserDetail default class
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            user = findByUsername(userDetail.getUsername());
        }
        return user;
    }

}
