package com.intelligrape.controller;

import com.intelligrape.model.User;
import com.intelligrape.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller("loginController")
@RequestMapping("/")
@Scope("session")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/")
    public String signIn()
    {
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHh logger");
        return "login/signIn";
    }

    @RequestMapping(value = "login/home")
    public String home(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request) {
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHh");
        String url = "redirect:/user/dashboard";
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            List<User> userList = loginService.getUser(userName, password);
            if (userList.size()>0) {
                currentUser = userList.get(0);
                request.getSession().setAttribute("currentUser", currentUser);
            } else {
                url = "redirect:/";
            }
        }
        return url;
    }

    @RequestMapping(value = "login/signUp")
    public String signUp() {
        return "login/signUp";
    }

    @RequestMapping(value = "login/logout")
    public String logout(HttpServletRequest request) {
        request.removeAttribute("currentUser");
        return "redirect:/";
    }
}
