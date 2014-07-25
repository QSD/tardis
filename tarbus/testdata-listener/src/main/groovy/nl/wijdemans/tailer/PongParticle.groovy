package nl.wijdemans.tailer;

import org.vertx.groovy.platform.Verticle

public class PongParticle extends Verticle {

    def start() {

        vertx.eventBus.registerHandler("ping-address") { message ->
            message.reply("pong!")
            container.logger.debug("Sent back pong groovy!")
        }
    }
}
