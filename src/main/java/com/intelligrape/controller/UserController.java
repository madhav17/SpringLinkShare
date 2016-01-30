package com.intelligrape.controller;

import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.service.UserService;
import com.intelligrape.util.CO.UserCO;
import com.intelligrape.util.enums.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller("userController")
@RequestMapping("/user")
@Scope("session")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    public String register(UserCO userCO) {
        if (userCO.firstName != null && userCO.lastName != null && userCO.username != null && userCO.password != null) {
            User currentUser = new User(userCO);
            userService.saveUserAndRole(currentUser, Role.ROLE_USER.name());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(HttpSession httpSession, Model model) {

        User currentUser = userService.getLoggedInUser();
        List<Topic> topicList = userService.findAllUserTopics(currentUser);
        httpSession.setAttribute("currentUser", currentUser);
        httpSession.setAttribute("username", currentUser.getFullName());
        httpSession.setAttribute("profileUrl", "/user/update?id=" + currentUser.getId());
        model.addAttribute("topics", topicList);
        return "user/dashboard";
    }

    @RequestMapping(value = "/ajaxDashboard")
    public ModelAndView ajaxDashboard(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User)httpSession.getAttribute("currentUser");
        List<Topic> topicList = userService.findAllUserTopics(user);
        modelAndView.addObject("topics",topicList);
        modelAndView.setViewName("user/ajaxDashboard");
        return modelAndView;
    }


    @RequestMapping(value = "/updateUser")
    public String updateUser(HttpSession httpSession,UserCO userCO) {
        User user = (User)httpSession.getAttribute("currentUser");
        userService.updateUser(user, userCO.firstName, userCO.lastName, userCO.password);
        return "redirect:/user/dashboard";
    }

    @RequestMapping(value = "/update")
    public String update(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("currentUser");
        model.addAttribute("user", user);
        return "user/update";
    }
}
