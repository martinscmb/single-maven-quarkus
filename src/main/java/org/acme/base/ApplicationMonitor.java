package org.acme.base;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.acme.event.ApplicationInitializationEvent;
import org.acme.event.ApplicationShuttingDownEvent;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * @author leandrosoares
 */
@ApplicationScoped
public class ApplicationMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMonitor.class);

    @Inject
    Event<ApplicationInitializationEvent> applicationInitializationEvent;

    @Inject
    Event<ApplicationShuttingDownEvent> applicationShuttingDownEvent;


    void onStart(@Observes StartupEvent evt) {
        applicationInitializationEvent.fire(new ApplicationInitializationEvent());
    }

    void onStop(@Observes ShutdownEvent evt) {
        applicationShuttingDownEvent.fire(new ApplicationShuttingDownEvent());
    }

}