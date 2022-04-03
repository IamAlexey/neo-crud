package com.example.neospring.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;

    @Relationship(type = "RATED", direction = Relationship.Direction.INCOMING)
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}