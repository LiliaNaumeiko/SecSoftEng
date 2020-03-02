package com.universitysys.SSE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String credit;
    @NotBlank
    public int professor_id;
    @NotBlank
    public int maxplace;
    @NotBlank
    public int enrolled_stud;
    @NotBlank
    public String school;

    public Module() {

    }

    public Module(Integer id, String name, String credit) {
        this.id= id;
        this.name = name;
        this.credit = credit;
    }

    public int getEnrolled_stud() {
        return enrolled_stud;
    }

    public int getMaxplace() {
        return maxplace;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public Integer getId() {
        return id;
    }

    public String getCredit() {
        return credit;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setEnrolled_stud(int enrolled_stud) {
        this.enrolled_stud = enrolled_stud;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaxplace(int maxplace) {
        this.maxplace = maxplace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
