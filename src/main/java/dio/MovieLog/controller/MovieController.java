package dio.MovieLog.controller;

import dio.MovieLog.domain.model.Movie;
import dio.MovieLog.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id){
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Movie>> findByGenre(@RequestParam String genre){
        List<Movie> movies = movieService.findByGenre(genre);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/year")
    public ResponseEntity<List<Movie>> findByYear(@RequestParam int year){
        List<Movie> movies = movieService.findByDate_Year(year);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Movie>> findByName(@RequestParam String name){
        List<Movie> movies = movieService.findByGenre(name);
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movieToCreate){
        Movie movieCreated = movieService.create(movieToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(movieCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(movieCreated);
    }


}
