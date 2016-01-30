package com.intelligrape.util.CO;

import com.intelligrape.model.Topic;
import com.intelligrape.model.User;

import java.util.Date;

public class SubscriptionCO {


    public int id;
    public User user;
    public Topic topic;
    public Date dateCreated;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
