package com.intelligrape.controller;

import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller("userController")
@RequestMapping("/user")
@Scope("session")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    public String listUser(HttpServletRequest request) {
        return "user/list";
    }


    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request, @RequestParam(value = "firstName",required = false) String firstName, @RequestParam(value = "lastName",required = false) String lastName, @RequestParam(value = "username",required = false) String username, @RequestParam(value = "password",required = false) String password) {
        if (firstName != null && lastName != null && username != null && password != null) {
            User currentUser = new User(firstName, lastName, username, password, true);
            userService.saveUserAndRole(currentUser, "ROLE_USER");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        User currentUser = userService.getLoggedInUser();
        List<Topic> topicList = userService.findAllUserTopics(currentUser);
        model.addAttribute("topics", topicList);
        model.addAttribute("user", currentUser);
        return "user/dashboard";
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser(HttpServletRequest request, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("password") String password, @RequestParam("id") int id) {
        User user = userService.getLoggedInUser();
        userService.updateUser(user, firstName, lastName, password);
        return "redirect:/user/dashboard";
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam("id") int id, Model model) {
        User user = userService.getLoggedInUser();
        model.addAttribute("user", user);
        return "user/update";
    }
}
