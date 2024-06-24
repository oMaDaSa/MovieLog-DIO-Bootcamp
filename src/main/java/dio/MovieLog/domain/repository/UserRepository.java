package dio.MovieLog.domain.repository;

import dio.MovieLog.domain.model.User;
import dio.MovieLog.domain.model.WatchedMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.watchedMovies FROM tb_user u WHERE u = :user")
    List<WatchedMovie> findWatchedMoviesByUser(User user);
}
