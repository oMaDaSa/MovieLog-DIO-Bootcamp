package dio.MovieLog.controller;

import dio.MovieLog.domain.model.Movie;
import dio.MovieLog.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/id")
    public ResponseEntity<Movie> findById(@RequestParam Long id){
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> movies = movieService.findAll();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Movie>> findByGenres(@RequestParam String genre){
        List<Movie> movies = movieService.findByGenresContaining(genre);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/year")
    public ResponseEntity<List<Movie>> findByYear(@RequestParam int year){
        List<Movie> movies = movieService.findByDate_Year(year);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Movie>> findByName(@RequestParam String name){
        List<Movie> movies = movieService.findByNameContaining(name);
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movieToCreate){
        Movie movieCreated = movieService.create(movieToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("")
                .queryParam("id", movieCreated.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).body(movieCreated);
    }


}
