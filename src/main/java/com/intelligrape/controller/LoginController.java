package com.intelligrape.controller;

import com.intelligrape.model.User;
import com.intelligrape.service.LoginService;
import com.intelligrape.service.UserService;
import com.intelligrape.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller("loginController")
@RequestMapping("/")
@Scope("session")
// Use 127.0.0.1 instead of localhost on linux
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    public final Logger log = Util.getLogger(LoginController.class);

    @RequestMapping(value = {"/login/welcome"}, method = RequestMethod.GET)
    public ModelAndView homePage(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/welcome");
        return modelAndView;
    }

    @RequestMapping(value = {"/", "/login/signIn"})
    //set below params becoz we required to check for login purpose
    public ModelAndView signIn(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Login Form - Database Authentication");
        model.addObject("message", "This is default page!");
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login/signIn");
        return model;
    }


    @RequestMapping(value = "/login/signUp")
    public String signUp() {
        return "login/signUp";
    }

    @RequestMapping(value = "login/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    //for 403 access decined page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            //UserDetail default class
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());

            model.setViewName("403");
        }
        return model;

    }
}
