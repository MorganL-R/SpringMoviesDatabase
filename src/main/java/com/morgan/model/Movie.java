package com.morgan.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@JsonIncludeProperties({"id", "title", "genre", "runtime", "rating", "actors"})
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

    public void setActors(Set<Actor> actors) {
        for (Actor actor: actors) {
            actor.setMovie(this);
        }
        this.actors = actors;
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", runtime=" + runtime +
                ", rating='" + rating + '\'' +
                ", actors=" + actors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
