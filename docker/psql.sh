#! /bin/bash

docker run -e PGPASSWORD=password  -it --rm --link turnip-db:postgres postgres psql -h postgres -U postgres $1
