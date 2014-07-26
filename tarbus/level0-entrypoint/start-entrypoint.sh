#!/bin/sh
cd /opt/level0-entrypoint
vertx run entrypoint.js -cluster-host 0.0.0.0 -cluster-port 6543 -cluster -instances 10
