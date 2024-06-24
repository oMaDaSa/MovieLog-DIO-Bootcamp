package dio.MovieLog.model;

import jakarta.persistence.*;

import java.util.ArrayList;
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
