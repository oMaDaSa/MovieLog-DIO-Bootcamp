package dio.MovieLog.model;

import jakarta.persistence.*;

@Entity(name = "tb_watchedMovies")
public class WatchedMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Movie movie;
    @Column(precision = 3)
    private int note;

    // Getters and Setters
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}

