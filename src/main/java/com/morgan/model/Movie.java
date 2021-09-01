package com.morgan.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Movie {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private int runtime;
    @Column
    private String rating;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Actor> actors;

    public void addActor(Actor actor){
        actor.setMovie(this);

        if (actors == null){
            actors = new HashSet<>();
        }

        actors.add(actor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
