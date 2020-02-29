package com.universitysys.SSE.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity // This tells Hibernate to make a table out of this class

@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String email) {
        this.password = email;
    }
}

