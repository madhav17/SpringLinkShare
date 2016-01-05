package com.intelligrape.configuration;

import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.service.TopicServiceImpl;
import com.intelligrape.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    @Autowired
    private UserService userService;

    @Autowired
    private TopicServiceImpl topicService;

    private  static final Logger log = LoggerFactory.getLogger(AppInitializer.class);
    public void onStartup(ServletContext container) throws ServletException {

        System.out.println("on Start up");
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        bootStrapData();

    }

    public void bootStrapData(){
        log.info("###########################################");
//        createUserAndTopic("Madhav", "Khanna", "madhav.khanna@tothenew.com", "1234", "First Topic");
//        createUserAndTopic("Maddy","Khanna","madhav.khanna@intelligrape.com","1234","Second Topic");
    }
    public void createUserAndTopic(String firstName,String lastName,String userName,String password,String title){
        User user = new User(firstName,lastName,userName,password);
        userService.saveUser(user);
        topicService.saveTopic(new Topic(user,title));
    }
}
