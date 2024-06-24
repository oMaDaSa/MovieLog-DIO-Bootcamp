package dio.MovieLog.controller;

import dio.MovieLog.domain.model.User;
import dio.MovieLog.domain.model.WatchedMovie;
import dio.MovieLog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserContoller {

    private final UserService userService;

    public UserContoller(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/WatchedMovies")
    public ResponseEntity<List<WatchedMovie>> findWatchedMoviesByUser(@PathVariable Long id){
        User user = findById(id).getBody();
        List<WatchedMovie> listWatchedMovies = userService.findWatchedMoviesByUser(user);
        return ResponseEntity.ok(listWatchedMovies);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        User userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }


}
