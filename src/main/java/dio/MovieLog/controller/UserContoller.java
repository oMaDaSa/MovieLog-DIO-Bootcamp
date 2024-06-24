package dio.MovieLog.controller;

import dio.MovieLog.domain.model.User;
import dio.MovieLog.domain.model.WatchedMovie;
import dio.MovieLog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserContoller {
    private final UserService userService;

    public UserContoller(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/id")
    public ResponseEntity<User> findById(@RequestParam Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/WatchedMovies")
    public ResponseEntity<List<WatchedMovie>> findWatchedMoviesByUser(@PathVariable Long id){
        User user = userService.findById(id);
        List<WatchedMovie> listWatchedMovies = userService.findWatchedMoviesByUser(user);
        return ResponseEntity.ok(listWatchedMovies);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        User userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("")
                .queryParam("id", userCreated.getId())
                .build()
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }



}
