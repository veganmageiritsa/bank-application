package com.bank.application.gatewayserver.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Order(1)
//@Component
//public class TraceFilter implements GlobalFilter {
//
//    private static final Logger logger = LoggerFactory.getLogger(TraceFilter.class);
//
//    private final FilterUtility filterUtility;
//
//    public TraceFilter(final FilterUtility filterUtility) {
//        this.filterUtility = filterUtility;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
//        if (isCorrelationIdPresent(requestHeaders)) {
//            logger.debug("Bank-correlation-id found in tracing filter: {}. ",
//                         filterUtility.getCorrelationId(requestHeaders));
//        } else {
//            String correlationID = generateCorrelationId();
//            exchange = filterUtility.setCorrelationId(exchange, correlationID);
//            logger.debug("Bank-correlation-id generated in tracing filter: {}.", correlationID);
//        }
//        return chain.filter(exchange);
//    }
//
//    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
//        return filterUtility.getCorrelationId(requestHeaders).equals(FilterUtility.CORRELATION_ID);
//    }
//
//    private String generateCorrelationId() {
//        return java.util.UUID.randomUUID().toString();
//    }
//}
