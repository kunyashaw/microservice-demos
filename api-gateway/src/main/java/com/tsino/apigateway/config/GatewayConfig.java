package com.tsino.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: admin
 * @Description: TODO
 * @Date: 2020/12/15 14:07
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return  builder.routes()
                .route("path_rout2",
                        r->r.path("/u/list").uri("http://localhost:8206/u/list")).build();
    }
}
