package dio.MovieLog.service.imp;

import dio.MovieLog.domain.model.Movie;
import dio.MovieLog.domain.model.WatchedMovie;
import dio.MovieLog.domain.repository.MovieRepository;
import dio.MovieLog.domain.repository.UserRepository;
import dio.MovieLog.domain.repository.WatchedMovieRepository;
import dio.MovieLog.service.WatchedMovieService;
import org.springframework.stereotype.Service;
import dio.MovieLog.domain.model.User;

import java.util.NoSuchElementException;

@Service
public class WatchedMovieServiceImp implements WatchedMovieService {
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    private final WatchedMovieRepository watchedMovieRepository;

    public WatchedMovieServiceImp(UserRepository userRepository, MovieRepository movieRepository, WatchedMovieRepository watchedMovieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.watchedMovieRepository = watchedMovieRepository;
    }

    @Override
    public WatchedMovie addWatchedMovie(Long userId, Long movieId, int rating) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Movie movie = movieRepository.findById(movieId).orElseThrow(NoSuchElementException::new);

        WatchedMovie watchedMovie = new WatchedMovie();
        watchedMovie.setMovie(movie);
        watchedMovie.setRating(rating);
        watchedMovieRepository.save(watchedMovie);

        user.getWatchedMovies().add(watchedMovie);
        userRepository.save(user);

        return watchedMovie;
    }
}
