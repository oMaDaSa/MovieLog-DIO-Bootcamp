package dio.MovieLog.service;

import dio.MovieLog.domain.model.User;
import dio.MovieLog.domain.model.WatchedMovie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User create(User user);
    List<WatchedMovie> findWatchedMoviesByUser(User user);
}
