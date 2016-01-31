package com.intelligrape.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service("mailHelperService")
@Transactional
public class MailHelperService {


    @Autowired
    public JavaMailSender javaMailSender;

    @Async
    public void sendMail(final String to,final String subject,final String body){

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {

                mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
                mimeMessage.setFrom(new InternetAddress("madhav.khanna@intelligrape.com"));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(body);

            }
        };

        try {
            javaMailSender.send(preparator);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
