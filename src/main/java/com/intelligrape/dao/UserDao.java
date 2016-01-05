package com.intelligrape.dao;

import com.intelligrape.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    void saveEmployee(User employee);

    List<User> findAllUser();
}
