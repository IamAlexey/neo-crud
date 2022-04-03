package com.example.neospring.service;

import com.example.neospring.dao.Movie;
import com.example.neospring.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@ManagedResource
public class MovieService {

    private final MovieRepository movieRepository;

    @ManagedOperation
    public Collection<Movie> getAll() {
        return movieRepository.findAll();
    }

    @ManagedOperation
    public Movie get(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @ManagedOperation
    public void save(String title, String director) {
        movieRepository.save(Movie.builder()
                .director(director)
                .title(title)
                .build());
    }

    @ManagedOperation
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}