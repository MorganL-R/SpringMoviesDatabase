package com.morgan.api;

import com.morgan.model.Movie;
import com.morgan.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class MovieController {

    @Autowired
    private MovieRepo movieRepo;
    /**
     * This is a POST API
     */
    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public void createMovie(@RequestBody Movie movie){
        movieRepo.save(movie);
    }

    /**
     *
     This is a GET API
     */
    @RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieRepo.getById(id);
    }

    /**
     *
     * This is a PUT API
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void updateMovie(Movie movie){

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteMovie(){

    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public List <Movie> getAllMovies(){
        return movieRepo.findAll();
    }

}
