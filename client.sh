#!/bin/bash



curl http://localhost:8080/api/photos/$1 -v --output image.png
