package com.beerek.indexer.controller;

import reactor.core.publisher.Mono;

public interface PlaceController {

    Mono<Long> countByCity(String cityId);
    Mono<Void> deleteAll();
    Mono<Void> deleteAllByCity(String cityId);
}
