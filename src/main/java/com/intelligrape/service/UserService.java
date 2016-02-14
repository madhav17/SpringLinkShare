package com.intelligrape.service;


import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.util.enums.Role;

import java.util.List;

public interface UserService {

    User findById(int id);

    User saveUser(User employee);

    User saveUserAndRole(User employee,String role);

    User updateUser(User employee, String firstName, String lastName, String password);

    List<User> findAllUsers();

    List<Topic> findAllUserTopics(User user);

    User getLoggedInUser();

    User findByUsername(String username);

    Long countUserTopics(User user);

    Long countUserSubscribedTopics(User user);

    Long countUnSubscribedTopics(User user);

    Long countTopicsSubscribedToday(User user);
}
