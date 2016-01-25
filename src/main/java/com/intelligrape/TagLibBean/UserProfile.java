package com.intelligrape.TagLibBean;

import com.intelligrape.model.User;
import com.intelligrape.service.UserService;
import com.intelligrape.util.Util;
import com.mysql.jdbc.Driver;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/*
* cannot inject service here need to write native again
* */
public class UserProfile implements Serializable {

    private String fullName = null;
    private String url = null;
    private static Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    public UserProfile() {

    }

    public String getFullName() {
        if (fullName == null && !(auth instanceof AnonymousAuthenticationToken))
            fetchInfo();
        return fullName;
    }

    public String getUrl() {
        if (url == null && !(auth instanceof AnonymousAuthenticationToken))
            fetchInfo();
        return url;
    }

    public void intializeInfo(String username) {
        try {
            Connection connection = Util.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where username=?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                fullName = resultSet.getString("first_name") + " " + resultSet.getString("last_Name");
                url = "/user/update?id=" + resultSet.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        }

    }

    public void fetchInfo() {
        //UserDetail default class
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        intializeInfo(userDetail.getUsername());
    }
}
