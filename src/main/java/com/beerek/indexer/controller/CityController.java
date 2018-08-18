package com.beerek.indexer.controller;

import com.beerek.indexer.model.City;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CityController {

    Flux<City> findAllCities();
    Mono<Void> deleteCity(String id);
    Mono<City> saveCity(City city);
    Mono<Void> deleteAll();
}
