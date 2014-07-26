var vertx = require('vertx')
var container = require('vertx/container');
var logger = container.logger;
var _ = require('node_modules/underscore/underscore.js')


vertx.createHttpServer().requestHandler(function(req) {
    logger.info("Incoming request ")
    if ( req.method() == 'PUT' ) {
        logger.info("PUTting request")
        req.bodyHandler( function( body ) {
            logger.info("Setting body on bus : " + body)
            vertx.eventBus.publish( 'tarbus.entry', body )
        })
        req.response.status = 200
    }  else {
        logger.info("Got " + req.method() + "request")
        req.response.status = 405
    }
    req.response.end();
}).listen(8080, '0.0.0.0');