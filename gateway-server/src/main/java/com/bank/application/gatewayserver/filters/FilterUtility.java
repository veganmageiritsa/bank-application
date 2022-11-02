package com.bank.application.gatewayserver.filters;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class FilterUtility {
    
    public static final String CORRELATION_ID = "bank-correlation-id";
    
    public String getCorrelationId(HttpHeaders requestHeaders) {
            return Optional.ofNullable(requestHeaders.get(CORRELATION_ID))
                           .orElse(Collections.emptyList())
                           .stream()
                           .findFirst()
                           .orElse("no correlation");
    }
    
    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }
    
    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
    }
    
}
