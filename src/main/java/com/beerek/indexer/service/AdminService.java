package com.beerek.indexer.service;

import reactor.core.publisher.Mono;

public interface AdminService {

    Mono<Void> clearDataBase();
    Mono<Void> updateIndex(String url);
    Mono<Void> updateAllIndex();
}
