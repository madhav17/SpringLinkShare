package com.intelligrape.controller;

import com.intelligrape.model.User;
import com.intelligrape.service.LoginService;
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

    @RequestMapping(value = "/user/dashboard")
    public String home(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        String url = "redirect:/user/dashboard";
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            List<User> userList = loginService.getUser(username, password);
            if (userList.size() > 0) {
                currentUser = userList.get(0);
                request.getSession().setAttribute("currentUser", currentUser);
            } else {
                url = "redirect:/";
            }
        }
        return url;
    }

    @RequestMapping(value = "/login/signUp")
    public String signUp() {
        return "login/signUp";
    }

    @RequestMapping(value = "login/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
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
