#!/usr/bin/env bash
mvn package
echo "1. Execute simple case..."
mvn exec:java -Dexec.mainClass="com.mars.Main"
echo "2. Execute simple case..."
mvn exec:java -Dexec.mainClass="com.mars.MultipleRoversOnPlane"
echo "3. Execute in web container..."
mvn exec:java -Dexec.mainClass="com.mars.web.WebApplication"