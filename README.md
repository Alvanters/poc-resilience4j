# POC Resilience4J

## Run
`mvn spring-boot:run`

http://localhost:8080/resilience/retry-A
http://localhost:8080/resilience/retry-B
http://localhost:8080/resilience/retry-C
http://localhost:8080/resilience/retry-D/-1
http://localhost:8080/resilience/retry-D/1
http://localhost:8080/resilience/retry-D/0
http://localhost:8080/actuator/circuitbreakerevents/cb-instanceA