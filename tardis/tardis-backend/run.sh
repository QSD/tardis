#!/bin/bash
mvn clean install
java -jar target/tardis-backend-0.1.0-SNAPSHOT.jar server
