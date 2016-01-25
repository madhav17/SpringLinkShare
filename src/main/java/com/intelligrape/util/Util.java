package com.intelligrape.util;

import com.mysql.jdbc.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {

    public static Logger getLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }

    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springLink?user=root&password=igdefault");
        } catch (Exception e) {

        }
        return connection;
    }
}
