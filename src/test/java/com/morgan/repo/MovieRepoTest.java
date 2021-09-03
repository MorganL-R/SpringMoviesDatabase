package com.morgan.repo;

import com.morgan.model.Actor;
import com.morgan.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureTestDatabase
@SpringBootTest
public class MovieRepoTest {
    @Autowired
    private MovieRepo movieRepo;

    @Test
    public void testWriteMovie() {
        Movie movie = new Movie();
        movie.setId((long) 1);
        movie.setTitle("Spiral");
        movie.setGenre("Thriller");
        movie.setRuntime(93);
        movie.setRating("18");
        Actor actor = new Actor();
        actor.setName("Chris Rock");
        actor.setAge(56);
        actor.setGender("Male");
        movie.addActor(actor);
        movieRepo.save(movie);
    }

    @Test
    public void testWriteMovie2(){
        Movie movie = new Movie();
        movie.setId((long)2);
        movie.setTitle("The Green Mile");
        movie.setGenre("Drama");
        movie.setRuntime(189);
        movie.setRating("18");
        Actor actor = new Actor();
        actor.setName("Tom Hanks");
        actor.setAge(65);
        actor.setGender("Male");
        movie.addActor(actor);
        movieRepo.save(movie);
    }

}