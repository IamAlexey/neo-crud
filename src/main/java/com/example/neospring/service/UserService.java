package com.example.neospring.service;

import com.example.neospring.dao.Movie;
import com.example.neospring.dao.User;
import com.example.neospring.repository.MovieRepository;
import com.example.neospring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ManagedResource
public class UserService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @ManagedOperation
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }

    @ManagedOperation
    public User get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @ManagedOperation
    public void save(String name, Integer age, List<Long> moviesId) {
        List<Movie> movies = moviesId.stream()
                .map(movieRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());


        userRepository.save(User.builder()
                .name(name)
                .age(age)
                .movies(movies)
                .build());
    }

    @ManagedOperation
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}