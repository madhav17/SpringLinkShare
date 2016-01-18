package com.intelligrape.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
//@EnableWebMvcSecurity it is deprecated use above one
// above two annotation is important for spring 4 for reading name is not important
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*
* The name of the configureGlobal method is not important.
* However, it is important to only configure AuthenticationManagerBuilder
* in a class annotated with either @EnableWebSecurity, @EnableGlobalMethodSecurity, or @EnableGlobalAuthentication.
* Doing otherwise has unpredictable results.
*
*
* */
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//        It can be used for in memory authentication

//        For JDBC(Database)
        auth.jdbcAuthentication().dataSource(dataSource)
                // project below three field are neccessary else it will give error
                .usersByUsernameQuery("select username,password,enabled from user where username = ?")
                .authoritiesByUsernameQuery("select us.username,ur.role from user us,user_role ur where us.id = ur.user_id and us.username = ?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/","/login/signIn").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                .and()
                .formLogin().loginPage("/login/signIn").failureUrl("/login/signIn?error").defaultSuccessUrl("/user/dashboard")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login/signIn?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
    }
}
