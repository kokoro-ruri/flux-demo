package com.example.fluxdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @Package: com.example.fluxdemo.config
 * @ClassName: WebFluxSecurityConfig
 * @Description:
 * @UpdateDate: 2021/3/26 9:16
 */
@Configuration
@EnableWebFluxSecurity
public class WebFluxSecurityConfig implements WebFilter{
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        //配置webflux的context-path
        ServerHttpRequest request = exchange.getRequest();
        if (request.getURI().getPath().startsWith(contextPath)) {
            exchange = exchange.mutate().request(request.mutate().contextPath(contextPath).build()).build();
        }
        return chain.filter(exchange);
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.addFilterAfter(this, SecurityWebFiltersOrder.FIRST)
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/swagger*/**", "/webjars/**", "/v2/api-docs")		//swagger
                .permitAll()
                .and()
                .authorizeExchange()
                .pathMatchers("/static/**", "/file/**")		//静态资源
                .permitAll()
                .and()
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .formLogin();
        return http.build();
    }
}
