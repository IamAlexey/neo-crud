package com.example.neospring.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Getter
@Setter
@Builder
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String director;
}