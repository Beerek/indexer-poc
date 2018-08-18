package com.beerek.indexer.service;

import com.beerek.indexer.repository.PlaceRepository;
import com.beerek.indexer.model.Place;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Flux<Place> findAll() {
        log.debug("Retrieving all Place entries in db");
        return placeRepository.findAll();
    }

    @Override
    public Mono<Long> countAllByCity(String city) {
        Place probe = new Place();
        probe.setCity(city);

        log.debug(String.format("Counting all Place entries by probe = %s", probe.toString()));

        return placeRepository.count(Example.of(probe));
    }

    @Override
    public Mono<Void> deleteAll() {
        log.debug("Deleting all Place entries in db");
        return placeRepository.deleteAll();
    }
}
