package com.intelligrape.model;

import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="topic")
public class Topic {

    public Topic(){

    }

    public Topic(User user,String title){
        this.user  = user;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;


    @NotEmpty
    @Column(name = "title",nullable = false)
    public String title;

    @OneToOne
    @JoinColumn(name="user_id",nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    public User user;

    public String getTitle(){
        return title;
    }

    public int getId(){
        return id;
    }

}

/*
create table topic(id INT NOT NULL auto_increment,
title VARCHAR(100) NOT NULL,
user_id INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user(id));

* */