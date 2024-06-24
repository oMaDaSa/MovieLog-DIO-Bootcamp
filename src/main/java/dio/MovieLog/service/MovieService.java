package dio.MovieLog.service;

import dio.MovieLog.domain.model.Movie;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MovieService{
    Movie findById(Long id);

    List<Movie> findByName(String name);

    List<Movie> findByDate_Year(int year);

    List<Movie> findByGenre(String genre);

    Movie create(Movie movie);

}
