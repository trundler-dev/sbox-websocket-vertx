package dev.trundleroo.vert.vertx_example.verticle;

import dev.trundleroo.vert.vertx_example.handler.WebSocketHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.ext.web.Router;

public class ApiVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiVerticle.class);

    @Override
    public void start(Promise<Void> promise) {

        final Router router = Router.router(vertx);

        createWebSocketServer(vertx, promise, router);

    }

    private void createWebSocketServer(Vertx vertx, Promise<Void> promise, Router router) {
        
        final int port = 8888;
        LOGGER.info("Creating WebSocket Server.");

        vertx.createHttpServer()
            .webSocketHandler(new WebSocketHandler(vertx))
            .listen(port);

    }

    public void stop() {

    }

}