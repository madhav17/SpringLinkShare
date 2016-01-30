package com.intelligrape.service;


import com.intelligrape.util.MailSession;
import com.intelligrape.util.Util;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("mailHelperService")
@Transactional
public class MailHelperService {

    Logger log = Util.getLogger(this.getClass());

    @Async
    void sendMailViaSMTP() {

        try {
            Message message = new MimeMessage(MailSession.getSession());
            message.setFrom(new InternetAddress(MailSession.fetchProperty("mail.username")));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("madhav.devil@gmail.com"));
//            InternetAddress[] ccInternetAddresses = mailDTO.getCCInternetAddress()
//            if (ccInternetAddresses)
//                message.setRecipients(Message.RecipientType.CC, ccInternetAddresses);
//            message.setSubject(mailDTO.subject);
//            message.setContent(mailDTO.content, "text/html");
            message.setSubject("Hello");
            message.setContent("Hello Hi", "text/html");
            Transport transport = MailSession.getTransport();
            if (transport != null && message.getAllRecipients() != null) {
                transport.sendMessage(message, message.getAllRecipients());
                log.info("Mail Send");
            }

        } catch (SendFailedException e) {
            log.info(e.toString());
            log.info(e.getInvalidAddresses().toString());
            log.info(e.getValidUnsentAddresses().toString());
            e.printStackTrace();
        } catch (MessagingException e) {
            log.info(e.toString());
            e.printStackTrace();
        }
    }
}
