package com.neuedu.credit.util;

import com.neuedu.credit.util.config.EmailConfig;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

/**
 * @Created by elvin on 2018/9/26 10:11.
 * @Describe:
 */
@Service(value = "EmailUtil")
public class EmailUtilImp implements EmailUtil {

        @Autowired
        private EmailConfig emailConfig;
        @Autowired
        private JavaMailSender mailSender;


        public void sendSimpleMail(String sendTo, String titel, String content) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailConfig.getEmailFrom());
            message.setTo(sendTo);
            message.setSubject(titel);
            message.setText(content);
            mailSender.send(message);
        }

        public void sendAttachmentsMail(String sendTo, String titel, String content, List<Pair<String, File>> attachments) {

            MimeMessage mimeMessage = mailSender.createMimeMessage();

            try {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(emailConfig.getEmailFrom());
                helper.setTo(sendTo);
                helper.setSubject(titel);
                helper.setText(content);

                for (Pair<String, File> pair : attachments) {
                    helper.addAttachment(pair.getKey(), new FileSystemResource(pair.getValue()));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            mailSender.send(mimeMessage);
        }

}
