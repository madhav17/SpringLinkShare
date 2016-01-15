package com.intelligrape.service;


import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.util.enums.Role;

import java.util.List;

public interface UserService {

    User findById(int id);

    void saveUser(User employee);

    void saveUserAndRole(User employee,String role);

    void updateUser(User employee, String firstName, String lastName, String password);

    List<User> findAllUsers();

    List<Topic> findAllUserTopics(User user);
}
