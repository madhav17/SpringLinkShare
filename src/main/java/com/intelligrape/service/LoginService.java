package com.intelligrape.service;

import com.intelligrape.model.User;

import java.util.List;

public interface LoginService {

    public List<User> getUser(String username, String password);
}
