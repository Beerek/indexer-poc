package com.beerek.indexer.service;

import com.beerek.indexer.model.City;
import com.beerek.indexer.model.Place;
import reactor.core.publisher.Flux;

public interface IndexerService {

    Flux<Place> findAllPlacesByCity(City city);

    Flux<Place> updateIndex();
}
