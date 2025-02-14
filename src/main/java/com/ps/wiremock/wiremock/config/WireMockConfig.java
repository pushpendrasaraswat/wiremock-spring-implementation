package com.ps.wiremock.wiremock.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Configuration
@RequiredArgsConstructor
@Slf4j
@ConditionalOnProperty(name = "wiremock.enabled", havingValue = "true")
public class WireMockConfig {

    @Value("${wiremock.port}")
    private int port;
    @Value("${wiremock.mocks.path}")
    private String wireMockPath;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer() {
        log.info("Starting Wire Mock server at port - {}", port);
        return new WireMockServer(WireMockConfiguration.options().port(port).usingFilesUnderDirectory(wireMockPath).disableRequestJournal());
    }
}

