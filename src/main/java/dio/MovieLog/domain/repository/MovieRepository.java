package dio.MovieLog.domain.repository;

import dio.MovieLog.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie>  findByName(String name);

    @Query("SELECT m FROM tb_movie m WHERE YEAR(m.releaseDate) = :year")
    List<Movie> findByYear(@Param("year") int year);

    List<Movie>  findByGenre(String genre);
}