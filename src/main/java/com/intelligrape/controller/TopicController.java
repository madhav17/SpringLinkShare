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

import javax.servlet.http.HttpServletRequest;

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


//    @RequestMapping(value = "/create")
//    public String create() {
//        Topic topic = new Topic();
//        topic.title = "Topic 1";
//        topic.user = userService.findById((int) 1);
//        System.out.println("errors");
//        System.out.println("errors");
//        topicService.saveTopic(topic);
//        return "topic/list";
//    }
    @RequestMapping(value = "/create")
    public String create(){
        return "topic/create";
    }

    @RequestMapping(value = "/save")
    public String save(HttpServletRequest request,@RequestParam("title") String title) {
        Topic topic = new Topic();
        topic.title = title;
        topic.user = (User)request.getSession().getAttribute("currentUser");
        topicService.saveTopic(topic);
        return "redirect:/user/dashboard";
    }

    @RequestMapping(value = "/updateTopic")
    public String updateTopic(HttpServletRequest request,@RequestParam("title") String title,@RequestParam("id") int id) {
        Topic topic = topicService.findById(id);
        topicService.updateTopic(topic, title);
        return "redirect:/user/dashboard";
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam("id") int id,Model model) {
        Topic topic = topicService.findById(id);
        model.addAttribute("topic",topic);
        return "topic/update";
    }
}
