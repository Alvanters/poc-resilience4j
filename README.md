# POC Resilience4J

## Run
`mvn spring-boot:run`

http://localhost:8080/actuator/health
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/circuitbreakerevents
http://localhost:8080/actuator/circuitbreakerevents/{name}/{eventType}
http://localhost:8080/actuator/circuitbreakerevents/{name}
http://localhost:8080/actuator/circuitbreakers
http://localhost:8080/actuator/circuitbreakers/{name}



http://localhost:8080/actuator/retryevents/re-instanceA
http://localhost:8080/actuator/circuitbreakerevents/cb-instanceA