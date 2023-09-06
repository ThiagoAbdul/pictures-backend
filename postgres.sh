#!/bin/bash

docker-compose up -d
docker exec -it postgres_pictures_app /bin/bash

