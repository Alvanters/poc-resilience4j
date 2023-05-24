package nl.alvant.resilience4j.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class DemoService {

    @Retry(name = "retryA", fallbackMethod = "fallBack")
    public String retryA() {
        log("retryA");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:6060/service2", String.class);
    }

    @Retry(name = "retryB", fallbackMethod = "fallBack")
    public String retryB() {
        log("retryB");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:6060/service2", String.class);
    }

    @Retry(name = "retryB", fallbackMethod = "fallBack")
    public String retryC() {
        log("retryC");
        double random = Math.random();
        if (random <= 0.8) {
            throw new RuntimeException("Retry Remote Call Fails");
        }
        System.out.println(Thread.currentThread().getName() + " - retryC SUCCESS- " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return "Success";
    }

    @CircuitBreaker(name = "circuitD", fallbackMethod = "fallback")
    @Retry(name = "retryD")
    public String retryD(int success) {
        log("retryD");
        if (success == 0) {
            double random = Math.random();
            if (random <= 0.8) {
                throw new RuntimeException("Retry Remote Call Fails");
            }
            return "Success";
        } else if (success < 0) {
            throw new RuntimeException("Retry Remote Call Fails");
        } else {
            return "Success";
        }
    }

    private void log(String call) {
        System.out.println(Thread.currentThread().getName() + " - " + call + " - " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public String fallBack(Exception e) {
        log("fallback");
        return String.format("Fallback Execution. Error Message: %s\n", e.getMessage());
    }

    public String fallback(int success, Exception e) {
        log("fallback with success " + success);
        return String.format("Fallback Execution. Error Message: %s\n", e.getMessage());
    }
}