package com.morgan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;

@Entity
@JsonIncludeProperties({"id", "name", "age", "gender"})
public class Actor {
    @Id
    @Column(name = "actor_id")
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false)
    private Movie movie;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
