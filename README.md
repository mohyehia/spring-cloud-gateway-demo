# spring-cloud-gateway-demo

### Overview
- In this repo, We will learn how to configure an API gateway to route traffic to your microservices architecture and implement solutions to improve the resilience of the system with patterns like circuit breakers, retries, fallbacks, and rate limiters using Spring Cloud Circuit Breaker and Resilience4J.
- We will also check how to improve the observability of the system using Spring Boot Actuator and Micrometer and relying on the Grafana stack.

### Technologies
- Java 17
- Spring Boot 3
- Spring Cloud Gateway
- Grafana OSS
- Docker


### Usage
You can use Docker Compose to set up the entire system, including applications, data services, and the Grafana observability stack.
<br/>
From the project root folder, run the following command to start the application:
```shell
docker-compose up -d
```
The `api-gateway` is exposed on port `9000` while the `book-service` is exposed on port `9001`.


### Observability Stack
- Both Spring Boot applications are observable, as any cloud native application should. 
- Prometheus' metrics are backed by Spring Boot Actuator and Micrometer Metrics.
- Distributed tracing is backed by Micrometer Tracing.
- **Grafana** lets you query and visualize logs, metrics, and traces from your applications. After running the Docker Compose configuration as explained in the previous section, you can access Grafana on port `3000`. It provides already dashboards to visualize metrics from Spring Boot, Spring Cloud Gateway, and Spring Cloud Circuit Breaker. 
- In the "Explore" panel, you can query logs from Loki, metrics from Prometheus, and traces from Tempo.
- **Loki** is a log aggregation system part of the Grafana observability stack. "It's like Prometheus, but for logs." Logs are available for inspecting from Grafana.
- **Tempo** is a distributed tracing backend part of the Grafana observability stack. Spring Boot applications sends traces to Tempo, which made them available for inspecting from Grafana. The traces follow the OpenTelemetry format and protocol.
- **Prometheus** is a monitoring system part of the Grafana observability stack. It parses the metrics endpoints exposed by Spring Boot applications (`/actuator/prometheus`).
- Metrics are available for inspecting and dashboarding from Grafana.


### Dashboards
- [JVM (Micrometer)](https://grafana.com/grafana/dashboards/4701-jvm-micrometer/)
- [Spring Boot Observability](https://grafana.com/grafana/dashboards/17175-spring-boot-observability/)
- [Spring Cloud Gateway](https://grafana.com/grafana/dashboards/11506-spring-cloud-gateway/)
- [Spring Boot Resilience4j Circuit Breaker (3.x)](https://grafana.com/grafana/dashboards/21307-circuit-breaker/)
- [Resilience4j Grafana Dashboard](https://github.com/resilience4j/resilience4j/blob/master/grafana_dashboard.json)

### References
- [Spring Cloud Gateway: Resilience, Security, and Observability w/ Thomas Vitale](https://www.youtube.com/watch?v=UXcCHX_ymag)
- [Spring Cloud Gateway - Resilience, Security, and Observability](https://github.com/ThomasVitale/spring-cloud-gateway-resilience-security-observability)
- [Spring Cloud Gateway RequestRateLimiter Filter](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/gatewayfilter-factories/requestratelimiter-factory.html)
- [Spring Cloud Gateway CircuitBreaker Filter](https://docs.spring.io/spring-cloud-gateway/reference/spring-cloud-gateway/gatewayfilter-factories/circuitbreaker-filter-factory.html)