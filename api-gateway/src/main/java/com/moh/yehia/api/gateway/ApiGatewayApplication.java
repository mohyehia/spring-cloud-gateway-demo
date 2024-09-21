package com.moh.yehia.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        Hooks.enableAutomaticContextPropagation();

        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    KeyResolver keyResolver() {
        return exchange -> Mono.just("ANONYMOUS");
    }

}

@RestController
class FallbackController {
    private static final Logger log = Logger.getLogger(FallbackController.class.getName());

    @GetMapping("/books-fallback")
    Flux<Void> findBooksFallback() {
        log.info("FallbackController :: findBooksFallback :: Returning empty list of books");
        return Flux.empty();
    }
}