/**
 * Created by jeroen on 25-7-14.
 */
var vertx = require('vertx');

var eb = vertx.eventBus;

var container = require('vertx/container');
var logger = container.logger;


var myHandler = function(message) {
    logger.info('I received a message ' + message);
}

logger.info("registring on 'tarbus.entry'")
eb.registerHandler('tarbus.entry', myHandler);
