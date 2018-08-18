package com.beerek.indexer.repository;

import com.beerek.indexer.model.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CityRepository extends ReactiveMongoRepository<City, String> {
}
