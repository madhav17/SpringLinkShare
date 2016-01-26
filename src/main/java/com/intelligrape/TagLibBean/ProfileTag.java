package com.intelligrape.TagLibBean;

import com.intelligrape.model.User;
import com.intelligrape.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ProfileTag extends SimpleTagSupport{
    @Override
    public void doTag() {
        try {
            JspWriter out = getJspContext().getOut();
            // Get the Spring application context


            WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(((PageContext) getJspContext()).getServletContext());

            // Get the ProductService bean
            UserService userService = (UserService)springContext.getBean(UserService.class);
            out.println(getProfileUrl(userService.getLoggedInUser()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public String getProfileUrl(User user){
        return "/user/update?id=" + user.getId();
    }
}
