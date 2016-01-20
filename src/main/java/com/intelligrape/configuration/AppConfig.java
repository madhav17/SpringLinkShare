package com.intelligrape.configuration;

import com.intelligrape.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
// above two annotation is important for spring 4 for reading,class name is not important
@ComponentScan(basePackages = "com.intelligrape")
@Import({SecurityConfig.class})
public class AppConfig extends WebMvcConfigurerAdapter implements ApplicationListener<ContextRefreshedEvent>  {

    @Autowired
    public UtilService utilService;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Override
    /*
    * This method comes from ApplicationListener which is bind to listen the ContextRefreshedEvent and call this
    * method whenever the  context is started (or refreshed).
    */
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        utilService.bootStrapData();
    }

    @Override
    // For Sitemesh so that we can access file from web.resources folder

    /*
    * You should remove 'Jsp View Resolver' from 'myapp-servlet.xml' file as you are planning to use only 'Tiles View Resolver'.

Regarding static resources, the way you referenced your static resources in baselayout.jsp, you have to move your static resources folder outside 'WEB-INF' folder.
Update resources location on myapp-servlet.xml file:
    * */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
