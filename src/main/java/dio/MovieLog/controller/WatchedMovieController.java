package dio.MovieLog.controller;

import dio.MovieLog.domain.model.WatchedMovie;
import dio.MovieLog.service.WatchedMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/watchedMovie")
public class WatchedMovieController {
    private final WatchedMovieService watchedMovieService;

    public WatchedMovieController(WatchedMovieService watchedMovieService){
        this.watchedMovieService = watchedMovieService;
    }

    @PostMapping()
    public ResponseEntity<WatchedMovie> addWatchedMovie(@RequestParam Long userId, @RequestParam Long movieId, @RequestParam int rating){
        WatchedMovie movie = watchedMovieService.addWatchedMovie(userId, movieId, rating);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("")
                .queryParam("id", movie.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).body(movie);
    }
}
