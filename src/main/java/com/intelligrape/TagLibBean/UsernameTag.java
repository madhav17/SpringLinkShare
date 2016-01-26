package com.intelligrape.TagLibBean;

import com.intelligrape.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import com.intelligrape.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Configuration
/*
@Configurable - aspectJ allows you to plug a weaver at load-time/compile-time,
so that even objects that are not instantiated by spring can be spring aware

 http://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/aop.html#aop-using-aspectj

  */

/*another Soultion above solution may not work

The servlet container is creating instances of your tag class, which is not under control of Spring, so autowiring does not work in a tag class. Autowiring only works for Spring beans - objects that are created by Spring.

You can lookup the Spring web application context and then get your ProductService bean from it:
 */
public class UsernameTag extends SimpleTagSupport {


    @Override
    public void doTag() {
        try {
            JspWriter out = getJspContext().getOut();
            // Get the Spring application context


            WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(((PageContext) getJspContext()).getServletContext());

            // Get the ProductService bean
            UserService userService = (UserService)springContext.getBean(UserService.class);

            User user = userService.getLoggedInUser();
            out.println(user.getFullName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
