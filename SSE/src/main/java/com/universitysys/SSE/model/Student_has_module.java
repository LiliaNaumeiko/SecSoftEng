package com.universitysys.SSE.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student_has_module {
    @Id
    private int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
