package com.bank.application.gatewayserver.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Configuration
//public class ResponseTraceFilter {
//
//    private static final Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);
//
//    @Bean
//    public GlobalFilter postGlobalFilter(FilterUtility filterUtility) {
//        return (exchange, chain) ->
//            chain.filter(exchange)
//                 .then(Mono.fromRunnable(() -> {
//                     HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
//                     String correlationId = filterUtility.getCorrelationId(requestHeaders);
//                     logger.debug("Updated the correlation id to the outbound headers. {}", correlationId);
//                     exchange.getResponse().getHeaders().add(FilterUtility.CORRELATION_ID, correlationId);
//                 }));
//    }
//
//}
