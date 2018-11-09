#! /bin/bash

docker run -e "PGPASSWORD=password" -i --rm --link turnip-db:postgres postgres psql -h postgres -U postgres -c "CREATE DATABASE organisation_api"
