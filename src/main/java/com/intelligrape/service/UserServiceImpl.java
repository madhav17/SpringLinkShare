package com.intelligrape.service;

import com.intelligrape.dao.UserDao;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.util.enums.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Autowired
    private SessionFactory sessionFactory;

    public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public User findById(int id) {
        log.error("dsfdsfdsfdsfdsfdsfdsf");
        return userDao.findById(id);
    }

    @Transactional
    public void saveUser(User user) {
        userDao.saveEmployee(user);
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
    public void saveUserAndRole(User employee,String role){
        userDao.saveEmployeeAndRole(employee,role);
    }

}
