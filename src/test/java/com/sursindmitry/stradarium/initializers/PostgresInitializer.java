package com.sursindmitry.stradarium.initializers;

import com.sursindmitry.stradarium.initializers.container.PostgresTestContainer;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext context) {

        PostgreSQLContainer<?> container =
            PostgresTestContainer.getInstance();

        TestPropertyValues.of(
            "spring.datasource.url=" + container.getJdbcUrl(),
            "spring.datasource.username=" + container.getUsername(),
            "spring.datasource.password=" + container.getPassword()
        ).applyTo(context.getEnvironment());
    }
}
