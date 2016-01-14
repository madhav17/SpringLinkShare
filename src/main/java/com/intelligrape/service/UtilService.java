package com.intelligrape.service;


import com.intelligrape.dao.TopicDao;
import com.intelligrape.dao.UserDao;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.util.Util;
import com.intelligrape.util.enums.Role;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service("utilService")
@Transactional
public class UtilService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public TopicDao topicDao;

    @Autowired
    public UserService userService;

    @Autowired
    public TopicService topicService;

    @Autowired
    public SessionFactory sessionFactory;

    private  static final Logger log = Util.getLogger(UtilService.class);

    @PostConstruct
    public void bootStrapData(){
        log.error("sdfdsfsdfdsfdsfdsfdsfdsfdsfdsf");
//        createUserAndTopic("Madhav", "Khanna", "madhav.khanna@tothenew.com", "1234", "First Topic");
//        createUserAndTopic("Maddy","Khanna","madhav.khanna@intelligrape.com","1234","Second Topic");
    }
    public void createUserAndTopic(String firstName,String lastName,String username,String password,String title){
        User user = new User(firstName,lastName,username,password);
//        userService.saveUserAndRole(user,Role.ROLE_USER);
//        topicService.saveTopic(new Topic(user,title));
    }

    public Object saveEntity(Object entity){
        sessionFactory.getCurrentSession().persist(entity);
        return entity;
    }
}
