package com.intelligrape.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
public class User implements Serializable {

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public User() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotEmpty
    @Column(name = "first_name", nullable = false)
    public String firstName;

    @NotEmpty
    @Column(name = "last_name", nullable = false)
    public String lastName;

    @NotEmpty
    @Column(name = "username", nullable = false, unique = true)
    public String username;

    @NotEmpty
    @Column(name = "password", nullable = false)
    public String password;

    @NotEmpty
    @Column(name = "enabled", nullable = false)
    public boolean enabled;

//    @DateTimeFormat(pattern = "dd/MM/yyyy")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
//    @Column(name = "date_of_birth",nullable = false)
//    public Date dateOfBirth;
//    public LocalDate dateOfBirth;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean getEnabled() {
        return enabled;
    }


}


/*
*   Schema For User

create table user(id INT NOT NULL auto_increment,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
username VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
// date_of_birth DATE NOT NULL,
PRIMARY KEY (id));

* */
