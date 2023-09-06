#!/bin/bash

docker-compose up -d
./mvnw clean spring-boot:run
