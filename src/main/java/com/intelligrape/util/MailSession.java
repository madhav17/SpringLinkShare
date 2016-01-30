package com.intelligrape.util;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import java.io.FileInputStream;
import java.util.Properties;

public class MailSession {

    private static Session session;
    private static Transport transport;


    public static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fetchProperty("mail.username"), fetchProperty("mail.password"));
                    }
                }
        );

        return session;
    }

    public static Transport getTransport() {
        try {
            transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", 465, fetchProperty("mail.username"), fetchProperty("mail.password"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return transport;
    }

    public static String fetchProperty(String prop) {
        String value = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("application.properties"));
            value = properties.getProperty(prop);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return value;
    }
}
