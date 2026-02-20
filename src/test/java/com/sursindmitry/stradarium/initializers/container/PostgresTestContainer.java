package com.sursindmitry.stradarium.initializers.container;

import org.testcontainers.containers.PostgreSQLContainer;

public final class PostgresTestContainer {

    private static PostgreSQLContainer<?> container;

    private PostgresTestContainer() {
    }

    public static synchronized PostgreSQLContainer<?> getInstance() {
        if (container == null) {
            container = new PostgreSQLContainer<>("postgres:17")
                .withDatabaseName("test")
                .withUsername("test")
                .withPassword("test");
            container.start();
        }
        return container;
    }
}