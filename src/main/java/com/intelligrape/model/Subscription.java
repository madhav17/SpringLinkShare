package com.intelligrape.model;

import com.intelligrape.util.CO.SubscriptionCO;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "subscription")
public class Subscription {

    public Subscription(){

    }

    public Subscription(User user,Topic topic,Date dateCreated){
        this.user = user;
        this.topic = topic;
        this.dateCreated = dateCreated;
    }

    public Subscription(SubscriptionCO subscriptionCO){
        user = subscriptionCO.user;
        topic = subscriptionCO.topic;
        dateCreated = subscriptionCO.dateCreated;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    @Cascade(CascadeType.ALL)
    public User user;

    @ManyToOne
    @JoinColumn(name = "topic_id",nullable = false)
    @Cascade(CascadeType.ALL)
    public Topic topic;

    @NotNull
//    @NotEmpty will not work for Date
    @Column(name = "date_created",nullable = false)
    public Date dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }



}
