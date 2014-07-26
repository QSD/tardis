
# Goal

To start a vert.x. container that is the entry point to the Tarbus application

## Interface

The entry point is a simple PUT request

curl -i -H "Accept: application/json" -X PUT -d "phone=1-800-999-9999" http://level0-entrypoint.dev.qsd.nl/

The service runs on:

level0-entrypoint.dev.qsd.nl


49153