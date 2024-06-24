package dio.MovieLog.service.imp;

import dio.MovieLog.domain.model.Movie;
import dio.MovieLog.domain.repository.MovieRepository;
import dio.MovieLog.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieServiceImp implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImp(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findByNameContaining(String name) {
        List<Movie> movieList = movieRepository.findByNameContaining(name);

        if(movieList.isEmpty()){
            throw new NoSuchElementException("No movie named like this found");
        }else
            return movieList;
    }

    @Override
    public List<Movie> findByDate_Year(int year) {
        List<Movie> movieList = movieRepository.findByYear(year);

        if(movieList.isEmpty()){
            throw new NoSuchElementException("No movie from this date found");
        }else
            return movieList;
    }

    @Override
    public List<Movie> findByGenresContaining(String genre) {
        List<Movie> movieList = movieRepository.findByGenresContaining(genre);

        if(movieList.isEmpty()){
            throw new NoSuchElementException("No movie from this genre found");
        }else
            return movieList;
    }

    @Override
    public Movie create(Movie movie) {
        if(movieRepository.existsById(movie.getId()) && movie.getId() != null)
            throw new IllegalArgumentException("This movie ID already exists");
        return movieRepository.save(movie);
    }
}
