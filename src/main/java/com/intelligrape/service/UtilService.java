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
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

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


    private  static final Logger log = Util.getLogger(UtilService.class);

    public void bootStrapData(){
        log.error("Bootstarp is called");
        createUserAndTopic("Madhav", "Khanna", "madhav.khanna@tothenew.com", "1234", "First Topic",true);
        createUserAndTopic("Maddy","Khanna","madhav.khanna@intelligrape.com","1234","Second Topic",true);
    }
    public void createUserAndTopic(String firstName,String lastName,String username,String password,String title,Boolean enabled){
        User user = new User(firstName,lastName,username,password,enabled);
        userService.saveUserAndRole(user,Role.ROLE_USER.name());
        topicService.saveTopic(new Topic(user,title));
    }

}
