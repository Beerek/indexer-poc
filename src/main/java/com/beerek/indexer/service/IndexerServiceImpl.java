package com.beerek.indexer.service;

import com.beerek.indexer.repository.CityRepository;
import com.beerek.indexer.repository.PlaceRepository;
import com.beerek.indexer.model.City;
import com.beerek.indexer.model.Place;
import com.beerek.indexer.remotes.PlacesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
public class IndexerServiceImpl implements IndexerService {

    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;

    private final static String REMOTE_API_TYPE = "GoogleRemoteApi";

    @Qualifier(REMOTE_API_TYPE)
    private final PlacesApi api;

    @Autowired
    public IndexerServiceImpl(CityRepository cityRepository, PlaceRepository placeRepository, PlacesApi api) {
        this.cityRepository = cityRepository;
        this.placeRepository = placeRepository;
        this.api = api;
    }

    @Override
    @Transactional
    public Flux<Place> findAllPlacesByCity(City city) {
        return api.fetchPlacesByCityID(city.getId())
                        .flatMap(placeRepository::save);
    }

    @Override
    public Flux<Place> updateIndex() {
        return cityRepository.findAll()
                .flatMap(this::findAllPlacesByCity);
    }
}
