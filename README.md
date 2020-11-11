# Recommendation Autocompletion API

## Requirements
### Without local compilation
- Docker
### With local compilation
- JDK 11
- Maven
- Lombok

## Execution through Docker.
```shell script
$ docker-compose up
```
## Local compilation execution

To compile and build a local docker image, type as follows:

```shell script
$ mvn clean package 
```
On the other hand, If only running this app locally without any image is required, just type:
```shell script
$ ./mvnw spring-boot:run
```
## Endpoint
- PUT: http://localhost:8999/recommended-words

## Swagger
- http://localhost:8999/swagger-ui.html

This endpoint receives a json object with two attributes: prefix and words with follow structure:
```json5
{
  "prefix": "et",
  "words": "Etiam capillus unus habet umbram"
}
```

They are validated as follows:
- Not Null
- Not Empty
- New Lines Are Not Allowed

# Observations:
It's build using the next technologies:
- Java 11.
- Spring Boot.
- Docker.
- Parallelism.
- Lambda Functional Programming.
 
This service allows requesting words recommendations, based on prefix parameter.
It works with 8 threads(in property file) to get a faster retrieval.
