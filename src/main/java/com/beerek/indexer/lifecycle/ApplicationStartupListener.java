package com.beerek.indexer.lifecycle;

import com.beerek.indexer.service.IndexScheduler;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ApplicationStartupListener implements ApplicationListener<ContextStartedEvent> {

    private final IndexScheduler scheduler;

    @Autowired
    public ApplicationStartupListener(IndexScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        log.info("Application started up!");
        log.info("Starting first index update...");
        scheduler.scheduleIndexUpdate();
    }
}

