package dio.MovieLog.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    @OneToMany
    private List<WatchedMovie> watchedMovies;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WatchedMovie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(List<WatchedMovie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
}
