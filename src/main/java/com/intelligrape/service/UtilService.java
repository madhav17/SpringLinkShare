package com.intelligrape.service;


import com.intelligrape.dao.TopicDao;
import com.intelligrape.dao.UserDao;
import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.util.Util;
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

    private  static final Logger log = Util.getLogger(UtilService.class);

    @PostConstruct
    public void bootStrapData(){
        System.out.print("sdfdsfsdfdsfdsfdsfdsfdsfdsfdsf");
        createUserAndTopic("Madhav", "Khanna", "madhav.khanna@tothenew.com", "1234", "First Topic");
        createUserAndTopic("Maddy","Khanna","madhav.khanna@intelligrape.com","1234","Second Topic");
    }
    public void createUserAndTopic(String firstName,String lastName,String userName,String password,String title){
        User user = new User(firstName,lastName,userName,password);
        userService.saveUser(user);
        topicService.saveTopic(new Topic(user,title));
    }
}
