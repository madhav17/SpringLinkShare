package com.intelligrape.controller;

import com.intelligrape.model.Topic;
import com.intelligrape.model.User;
import com.intelligrape.service.SubscriptionService;
import com.intelligrape.service.TopicService;
import com.intelligrape.service.UserService;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller("subscriptionController")
@RequestMapping("/subscription")
@Scope("session")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

//    @RequestMapping(value = "/subscribeTopic")
//    public ModelAndView subscribeTopic(HttpSession httpSession, @RequestParam("topicId") int topicId) {
//        ModelAndView modelAndView = new ModelAndView();
//        User currentUser = (User) httpSession.getAttribute("currentUser");
//        Topic topic = topicService.findById(topicId);
//        subscriptionService.createSubscription(currentUser, topic, new Date());
//        List<Topic> topicList = userService.findAllUserTopics(currentUser);
//        modelAndView.addObject("topicList", topicList);
//        modelAndView.setViewName("topic/topicListTemplate");
//        return modelAndView;
//    }

    @RequestMapping(value = "/subscribeTopicList")
    public ModelAndView subscribeTopicList(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        User currentUser = (User) httpSession.getAttribute("currentUser");
        List<Topic> allTopics = subscriptionService.fetchSubscribedTopics(currentUser);
        modelAndView.addObject("topicList", allTopics);
        modelAndView.addObject("subs", true);
        modelAndView.addObject("type", "Un Subscribe");
        modelAndView.setViewName("topic/topicListTemplate");
        return modelAndView;
    }

    @RequestMapping(value = "/subscribeTopic")
    public ModelAndView subscribeTopic(HttpSession httpSession, @RequestParam("topicId") int topicId) {
        ModelAndView modelAndView = new ModelAndView();
        Topic topic = topicService.findById(topicId);
        User user = (User) httpSession.getAttribute("currentUser");
        subscriptionService.createSubscription(user, topic, new Date());
        List<Topic> allTopics = subscriptionService.fetchUnSubscribedTopics(user);
        modelAndView.addObject("topicList", allTopics);
        modelAndView.addObject("subs", true);
        modelAndView.addObject("type", "Subscribe");
        modelAndView.setViewName("topic/topicListTemplate");
        return modelAndView;
    }

    @RequestMapping(value = "/unSubscribeTopicList")
    public ModelAndView unSubscribeTopicList(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        User currentUser = (User) httpSession.getAttribute("currentUser");
//        List<Topic> allTopics = topicService.findAllTopics();
//    allTopics.removeAll(userService.findAllUserTopics(currentUser));
//        allTopics = ListUtils.removeAll(allTopics, userService.findAllUserTopics(currentUser));
        List<Topic> allTopics = subscriptionService.fetchUnSubscribedTopics(currentUser);
        modelAndView.addObject("topicList", allTopics);
        modelAndView.addObject("subs", true);
        modelAndView.addObject("type", "Subscribe");
        modelAndView.setViewName("topic/topicListTemplate");
        return modelAndView;
    }

    @RequestMapping(value = "/unSubscribeTopic")
    public ModelAndView unSubscribeTopic(HttpSession httpSession, @RequestParam("topicId") int topicId) {
        ModelAndView modelAndView = new ModelAndView();
        Topic topic = topicService.findById(topicId);
        User user = (User) httpSession.getAttribute("currentUser");
        subscriptionService.deleteSubscription(user, topic);
        List<Topic> allTopics = subscriptionService.fetchSubscribedTopics(user);
        modelAndView.addObject("topicList", allTopics);
        modelAndView.addObject("subs", true);
        modelAndView.addObject("type", "Un Subscribe");
        modelAndView.setViewName("topic/topicListTemplate");
        return modelAndView;
    }

}
