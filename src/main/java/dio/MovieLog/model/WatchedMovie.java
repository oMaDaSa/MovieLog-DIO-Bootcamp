package dio.MovieLog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_WatchedMovies")

public class WatchedMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    @OneToOne
    private Movie movie;
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

