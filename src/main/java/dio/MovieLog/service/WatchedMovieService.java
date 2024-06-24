package dio.MovieLog.service;

import dio.MovieLog.domain.model.Movie;
import dio.MovieLog.domain.model.WatchedMovie;

public interface WatchedMovieService {


    public WatchedMovie addWatchedMovie(Long userId, Long movieId, int rating);


}
