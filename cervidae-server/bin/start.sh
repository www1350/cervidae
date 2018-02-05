#!/bin/bash
mvn clean install -DskipTests -U
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \
       -jar target/cervidae-server-1.0-SNAPSHOT.jar --spring.profiles.active=dev