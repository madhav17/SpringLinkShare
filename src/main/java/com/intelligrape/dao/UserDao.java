package com.intelligrape.dao;

import com.intelligrape.model.User;
import com.intelligrape.util.enums.Role;

import java.util.List;

public interface UserDao {

    User findById(int id);

    void saveEmployee(User employee);

    void saveEmployeeAndRole(User employee,String role);

    List<User> findAllUser();
}
