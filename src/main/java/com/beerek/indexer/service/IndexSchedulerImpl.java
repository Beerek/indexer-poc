package com.beerek.indexer.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Log4j2
@Service
@Scope("Singleton")
public class IndexSchedulerImpl implements IndexScheduler {

    private final WebClient webClient = WebClient.create();
    private final IndexerService indexerService;

    private final ScheduledExecutorService exec = new ScheduledThreadPoolExecutor(10);

//    TODO to properties
    private final static List<String> SERVICE_LIST = Collections.emptyList();
    private static final Long DELAY = 12L;
    private static final TimeUnit TIME_UNIT = TimeUnit.HOURS;

    @Autowired
    public IndexSchedulerImpl(IndexerService indexerService) {
        this.indexerService = indexerService;
    }

    @SuppressWarnings("Recursive")
    public void scheduleIndexUpdate() {
        log.info("Starting index update...");

        indexerService.updateIndex().flatMap(place ->
                Flux.fromStream(
                        SERVICE_LIST.stream()
                                .map(url ->
                                        webClient
                                                .put()
                                                .uri(url)
                                                .body(BodyInserters.fromObject(place))
                                                .exchange())
                                .peek(url -> log.debug(url + " update sent"))
                )
        );

        exec.schedule(this::scheduleIndexUpdate, DELAY, TIME_UNIT);
    }
}
