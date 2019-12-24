/*
 * Prozis Tech Copyright (c) 2019.
 */

package org.acme.dbrepo;

import org.acme.event.ApplicationInitializationEvent;
import org.acme.event.ApplicationShuttingDownEvent;
import org.acme.event.DatabaseShutdownEvent;
import org.acme.event.DatabaseStartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author leandrosoares
 */
@ApplicationScoped
public class DatabaseStartupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseStartupService.class);

    @Inject
    Event<DatabaseStartupEvent> databaseStartupEventEvent;

    @Inject
    Event<DatabaseShutdownEvent> databaseShutdownEvent;

    /*@ConfigProperty(name = "quarkus.datasource.url")
    protected String databaseJdbcUri;

    @ConfigProperty(name = "quarkus.datasource.username")
    protected String username;

    @ConfigProperty(name = "quarkus.datasource.password")
    protected String password;*/

    protected Server server;

    void onStart(@Observes ApplicationInitializationEvent evt) {

        try {
            startH2();
            databaseStartupEventEvent.fire(new DatabaseStartupEvent());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    void onStop(@Observes ApplicationShuttingDownEvent evt) {
        server.stop();
        databaseShutdownEvent.fire(new DatabaseShutdownEvent());
    }

    private void startH2() throws SQLException, ClassNotFoundException {
        server = Server.createTcpServer("-tcpAllowOthers").start();
        Class.forName("org.h2.Driver");
        //Connection conn = DriverManager.getConnection(this.databaseJdbcUri, this.username, this.password);
        //LOGGER.info("Connection Established: " + conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());
    }


}
