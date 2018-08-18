package com.beerek.indexer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class City {
    @Id
    private String id;
    private String name;
}
