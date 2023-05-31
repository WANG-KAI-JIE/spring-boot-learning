package top.kjwang.mail.service;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author kjwang
 * @date 2023/4/18 13:50
 * @description MailService
 */
@Service
public class MailService {
    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;


    /**
     * 发送简单邮件
     * @param to 收件人邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String to,String subject,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }

    /**
     * 发送 HTML 富文本邮件
     * @param to 收件人邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws MessagingException
     */
    public void sendHtmlMail(String to,String subject,String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        javaMailSender.send(message);
    }

    /**
     *
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendFreemarkerMail(String to,String subject,String content) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        javaMailSender.send(message);
    }
}
