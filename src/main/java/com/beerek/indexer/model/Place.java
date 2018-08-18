package com.beerek.indexer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Place {
    @Id
    private String id;
    private String name;

    private String city;

    private Double lat;
    private Double lon;

    private Double rating;
    private List<String> categories;
}
