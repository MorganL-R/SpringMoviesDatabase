package com.morgan.api;

import com.morgan.model.Movie;
import com.morgan.repo.MovieRepo;
import com.sun.xml.bind.v2.model.core.ID;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieRepo movieRepo;
    /**
     * This is a POST API
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createMovie(@RequestBody Movie movie){
        movieRepo.save(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     *
     This is a GET API
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieRepo.getById(id);
    }

    /**
     * This is a PUT API
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateMovie(@RequestBody Movie movie){
        if (movie.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        movieRepo.save(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if (movieRepo.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        movieRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieRepo.findAll();
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

}
