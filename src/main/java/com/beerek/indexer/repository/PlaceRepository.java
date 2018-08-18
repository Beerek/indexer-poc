package com.beerek.indexer.repository;

import com.beerek.indexer.model.Place;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaceRepository extends ReactiveMongoRepository<Place, String> {
}
