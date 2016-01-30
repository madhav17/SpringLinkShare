package com.intelligrape.controller;

import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.service.TopicService;
import com.intelligrape.service.UserService;
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

@Controller("topicController")
@RequestMapping("/topic")
@Scope("session")
public class TopicController {


    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    public String listTopic() {
        return "topic/list";
    }

    @RequestMapping(value = "/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("topic/create");
        return modelAndView;
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(HttpServletRequest request, @RequestParam("title") String title, @RequestParam("link") String link, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) httpSession.getAttribute("currentUser");
        Topic topic = new Topic(user, title, link);
        topicService.saveTopicCreateSubscription(topic, user);
        modelAndView.addObject("msg", ((topic != null) ? "Topic Created" : "Cannot Create Topic"));
        modelAndView.setViewName("topic/create");
        return modelAndView;
    }

    @RequestMapping(value = "/updateTopic")
    public String updateTopic(HttpServletRequest request, @RequestParam("title") String title, @RequestParam("id") int id, @RequestParam("link") String link) {
        Topic topic = topicService.findById(id);
        topicService.updateTopic(topic, title, link);
        return "redirect:/user/dashboard";
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam("id") int id, Model model) {
        Topic topic = topicService.findById(id);
        model.addAttribute("topic", topic);
        return "topic/update";
    }

    @RequestMapping(value = "/ajaxList")
    public ModelAndView list(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("currentUser");
        ModelAndView modelAndView = new ModelAndView();
        List<Topic> topicList = userService.findAllUserTopics(user);
        modelAndView.addObject("topicList", topicList);
        modelAndView.setViewName("topic/topicListTemplate");
        return modelAndView;
    }
}
