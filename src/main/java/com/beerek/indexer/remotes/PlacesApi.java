package com.beerek.indexer.remotes;

import com.beerek.indexer.model.Place;
import reactor.core.publisher.Flux;

public interface PlacesApi {
    Flux<Place> fetchPlacesByCityID(String cityId);
    Flux<Place> fetchPlacesByCityName(String cityName);
}
