package dio.MovieLog.service;

import dio.MovieLog.domain.model.Movie;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MovieService{
    Movie findById(Long id);

    List<Movie> findAll();

    List<Movie> findByNameContaining(String name);

    List<Movie> findByDate_Year(int year);

    List<Movie> findByGenresContaining(String genre);

    Movie create(Movie movie);

}
