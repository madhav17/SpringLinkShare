package com.intelligrape.model;

import com.intelligrape.util.CO.TopicCO;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "topic")
public class Topic {

    public Topic() {

    }

    public Topic(User user, String title, String link) {
        this.user = user;
        this.title = title;
        this.link = link;
        this.dateCreated = new Date();
    }

    public Topic(TopicCO topicCO) {
        user = topicCO.user;
        title = topicCO.title;
        link = topicCO.link;
        this.dateCreated = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;


    @NotEmpty
    @Column(name = "title", nullable = false)
    public String title;

    @NotEmpty
    @Column(name = "link", nullable = false)
    public String link;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User user;

    @NotNull
    @Column(name = "date_created",nullable = false)
    public Date dateCreated;

    @OneToMany(mappedBy = "topic") // Subscription model has topic
    @Cascade(CascadeType.ALL)
    public Set<Subscription> subscriptionSet;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "topic : " + id;
    }
}

/*
create table topic(id INT NOT NULL auto_increment,
title VARCHAR(100) NOT NULL,
user_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user(id));

* */