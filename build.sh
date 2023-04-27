#!/usr/bin/env bash
mvn clean install
docker build -t jpm/rover .
docker run jpm/rover
