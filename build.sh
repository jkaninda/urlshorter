#!/usr/bin/env bash
if [ $# -eq 0 ]
  then
    tag='latest'
  else
    tag=$1
fi
./mvnw  clean package

docker build -t jkaninda/urlshorter:$tag .