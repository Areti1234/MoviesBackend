package dev.areti.movies.service;

import dev.areti.movies.model.Movie;
import dev.areti.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie>allMovies(){
        return movieRepository.findAll();
    }
    public Optional<Movie> getMovieById(String id){
        return movieRepository.findMovieByImdbId(id);
    }
}
