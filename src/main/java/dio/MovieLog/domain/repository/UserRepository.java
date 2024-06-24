package dio.MovieLog.domain.repository;

import dio.MovieLog.domain.model.User;
import dio.MovieLog.domain.model.WatchedMovie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "watchedMovies")
    Optional<User> findById(Long id);
    @Query("SELECT u.watchedMovies FROM tb_user u WHERE u = :user")
    List<WatchedMovie> findWatchedMoviesByUser(User user);
}
