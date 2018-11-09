#! /bin/bash
cd "$(dirname "$0")"
echo "Starting docker"
if [ ! "$(docker ps -a -q -f 'name=turnip-db')" ]; then
  echo "Container does not exists, creating it"
  docker run --name turnip-db -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres:10
  echo "Sleeping for 20 s ensure postgres responds..."
  sleep 20
  ./create-databases.sh
else
  echo "Starting already initialised container"
  docker start turnip-db
fi