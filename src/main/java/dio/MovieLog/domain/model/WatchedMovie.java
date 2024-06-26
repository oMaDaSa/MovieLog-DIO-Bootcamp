package dio.MovieLog.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_watchedMovies")
public class WatchedMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Movie movie;
    @Column(precision = 3)
    private int rating;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int note) {
        this.rating = note;
    }

}

