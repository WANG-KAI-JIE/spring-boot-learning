package top.kjwang.mail.service;

import freemarker.template.Template;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import top.kjwang.entity.Article;

import java.util.*;

/**
 * @author kjwang
 * @date 2023/4/18 13:56
 * @description MailServiceTest
 */

@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;


    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("1729298243@qq.com","test","Hello");
    }

    @Test
    void sendHtmlMail() {
        try {
            mailService.sendHtmlMail("1729298243@qq.com","test", """
                    <body>
                    <div>
                    <h3>富文本邮件发送</h3>
                    <img src="https://fatcat666.oss-cn-nanjing.aliyuncs.com/image/202302250942314.png" style="width:100px">
                    <a style="text-decoration: none; color:#fff;" href="https://github.com/WANG-KAI-JIE">
                    <strong>我的Github主页</strong>
                    </div>
                    </body>""");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void sendFreemarkerMail() throws Exception {
        List<Article> articles = List.of(
                new Article(1,"Spring",new Date()),
                new Article(2,"Spring MVC",new Date()),
                new Article(3,"Spring Boot",new Date())
        );
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail-temp.ftl");
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articles);
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
        mailService.sendHtmlMail("1729298243@qq.com","这是一封FreeMarker模版引擎邮件",content);
    }
}