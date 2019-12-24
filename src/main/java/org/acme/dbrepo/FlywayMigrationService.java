/*
 * Prozis Tech Copyright (c) 2019.
 */

package org.acme.dbrepo;

import org.acme.event.DatabaseStartupEvent;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 * @author leandrosoares
 */
@ApplicationScoped
public class FlywayMigrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlywayMigrationService.class);

    @Inject
    Flyway flyway;


    public void checkMigration(@Observes DatabaseStartupEvent evt) {

        flyway.migrate();

        String version = flyway.info().current().getVersion().toString();
        LOGGER.info("Flyway version: {} ", version);
    }
}
