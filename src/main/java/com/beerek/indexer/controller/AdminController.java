package com.beerek.indexer.controller;

import reactor.core.publisher.Mono;

public interface AdminController {

    Mono<Void> clearDataBase();
    Mono<Void> dropDataBase();
    Mono<Void> createDataBase();
}
