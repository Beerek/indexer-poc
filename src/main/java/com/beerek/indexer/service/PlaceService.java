package com.beerek.indexer.service;

import com.beerek.indexer.model.Place;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaceService {

    Flux<Place> findAll();
    Mono<Long> countAllByCity(String city);
    Mono<Void> deleteAll();
}
