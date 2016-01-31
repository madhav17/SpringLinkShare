package com.intelligrape.configuration;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
// above two annotation is important for spring 4 for reading,class name is not important
@ComponentScan({ "com.intelligrape.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.intelligrape.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }


    /*
    * Hibernate related….

Create a session factory bean configuration file (Hibernate.xml), put it into the “resources/database” folder.
In annotation you have to use the AnnotationSessionFactoryBean, instead of LocalSessionFactoryBean,
and specify your annotated model classes in ‘annotatedClasses‘ property instead of ‘mappingResources‘ property.

used in hibernate 3 replacement is LocalSessionFactoryBean
    *
    * */
//    @Bean
//    public AnnotationSessionFactoryBean sessionFactory() {
//        AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(new String[] { "com.intelligrape.model" });
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setProtocol("smtp");
        javaMailSender.setUsername("madhav.khanna@intelligrape.com");
        javaMailSender.setPassword("khannavahdam");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.quitwait", false);
        props.put("mail.smtp.socketFactory.class", javax.net.ssl.SSLServerSocketFactory.class);
        props.put("mail.smtp.socketFactory.fallback", false);
        props.put("mail.debug", true);

        javaMailSender.setJavaMailProperties(props);
        return javaMailSender;

    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        // environment picks value from application.properties
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}