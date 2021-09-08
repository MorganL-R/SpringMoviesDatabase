package com.morgan.repo;

import com.morgan.model.Actor;
import com.morgan.model.Movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase
@SpringBootTest
public class MovieRepoReadTest {
    @Autowired
    private MovieRepo movieRepo;

    public void insertMovies() {
        movieRepo.deleteAll();
        Movie movie = new Movie();
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

        Movie movie2 = new Movie();
        movie2.setTitle("The Green Mile");
        movie2.setGenre("Drama");
        movie2.setRuntime(189);
        movie2.setRating("18");
        Actor actor2 = new Actor();
        actor2.setName("Tom Hanks");
        actor2.setAge(65);
        actor2.setGender("Male");
        movie2.addActor(actor2);
        movieRepo.save(movie2);
    }

    @Test
    public void testReadMovies() {
        insertMovies();
        List <Movie> movies = movieRepo.findAll();
        assertFalse(movies.isEmpty());
        assertEquals(2, movies.size());
        for (Movie movie : movies) {
            System.out.println(movie);
        }

    }

}
