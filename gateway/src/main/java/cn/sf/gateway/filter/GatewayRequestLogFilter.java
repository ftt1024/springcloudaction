package cn.sf.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class GatewayRequestLogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("LOG_ID:{}", exchange.getLogPrefix());
        ServerHttpRequest request = exchange.getRequest();
        log.info("path: {} address: {} method: {} URI: {} Headers: {} body: {}", request.getPath(),
                request.getRemoteAddress(), request.getMethodValue(), request.getURI(),
                request.getHeaders(), exchange.getAttribute("cachedRequestBodyObject"));
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}