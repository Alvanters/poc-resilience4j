package nl.alvant.resilience4j;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean
    public CircuitBreakerConfigCustomizer circuitBreakerConfigCustomizer() {
        return CircuitBreakerConfigCustomizer.of("cb-instanceB", builder -> builder.minimumNumberOfCalls(10)
                .permittedNumberOfCallsInHalfOpenState(15));
    }
}
