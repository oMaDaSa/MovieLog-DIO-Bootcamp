package dio.MovieLog.service.imp;

import dio.MovieLog.domain.model.User;
import dio.MovieLog.domain.model.WatchedMovie;
import dio.MovieLog.domain.repository.UserRepository;
import dio.MovieLog.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(userRepository.existsById(user.getId()) && user.getId() != null)
            throw new IllegalArgumentException("This user ID already exists");
        return userRepository.save(user);
    }

    @Override
    public List<WatchedMovie> findWatchedMoviesByUser(User user) {
        return userRepository.findWatchedMoviesByUser(user);
    }


}
