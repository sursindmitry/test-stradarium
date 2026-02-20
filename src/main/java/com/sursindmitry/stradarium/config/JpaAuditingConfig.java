package com.sursindmitry.stradarium.config;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Класс конфигурации JPA.
 */
@Configuration
@EnableJpaAuditing(
    modifyOnCreate = false,
    dateTimeProviderRef = "auditingDateTimeProvider"
)
public class JpaAuditingConfig {

    /**
     * Создаёт бин отвечающий за автоматическую подставку даты.
     *
     * @return {@link DateTimeProvider}
     */
    @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        return () -> Optional.of(LocalDateTime.now(ZoneOffset.UTC));
    }

}
