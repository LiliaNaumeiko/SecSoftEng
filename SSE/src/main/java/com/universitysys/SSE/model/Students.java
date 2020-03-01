package com.universitysys.SSE.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity // This tells Hibernate to make a table out of this class

@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    public Date date_of_birth;
    @NotBlank
    public String nationality;
    @NotBlank
    public String sex;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String email) {
            this.surname = surname;
    }
    public Date getDate_of_birth() {return date_of_birth;}

    public void setDate_of_birth(Date date_of_birth){this.date_of_birth = date_of_birth;}

    public String getNationality(){return nationality;}

    public void setNationality(String nationality){this.nationality = nationality;}

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
