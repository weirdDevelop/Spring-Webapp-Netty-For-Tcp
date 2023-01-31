package dev.danvega.jpasecurity.Service;

import com.example.demo.Repository.UserRepository;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class userService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    public userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
       return userRepository.findByUsername(username)
               .cast(UserDetails.class);
    }
}
