#!/bin/bash
mvn clean install -DskipTests
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \
       -jar target/cervidae-1.0-SNAPSHOT.jar --spring.profiles.active=dev