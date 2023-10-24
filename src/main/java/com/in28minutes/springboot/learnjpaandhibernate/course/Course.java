package com.in28minutes.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Created By dhhaval thakkar on 2023-10-24
 */
@Getter
@Setter
@Entity
public class Course {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    public Course() {
    }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
