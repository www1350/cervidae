#!/bin/bash
mvn clean install -DskipTests -U
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8001,suspend=n \
       -jar target/cervidae-consume-1.0-SNAPSHOT.jar --server.port=8081