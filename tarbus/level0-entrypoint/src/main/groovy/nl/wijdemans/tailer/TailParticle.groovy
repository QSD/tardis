package nl.wijdemans.tailer;

import org.vertx.groovy.platform.Verticle

public class TailParticle extends Verticle {

    public void start() {

        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest httpServerRequest) {
                httpServerRequest.response().end("Hello smartjava");
            }
        }).listen(8888);


        container.logger().info("Webserver started, listening on port: 8888");
    }
}
