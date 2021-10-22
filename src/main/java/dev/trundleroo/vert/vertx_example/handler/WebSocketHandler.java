package dev.trundleroo.vert.vertx_example.handler;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class WebSocketHandler implements Handler<ServerWebSocket> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketHandler.class); 
    private final Vertx vertx;
    private int clickCount = 0;

    public WebSocketHandler(Vertx vertx) {
        this.vertx = vertx;

        LOGGER.info(this.getClass().getName() + " has been initialized.");
    }

    @Override
    public void handle(ServerWebSocket webSocket) {

        webSocket.textMessageHandler((ctx) -> {
            if (webSocket.path().equals("/clicks")) {
                // Instead of incrementing a variable,
                // you could talk to a database here
                // for true persistence.
                clickCount++;
            }
        });

        // Sends an update to each connection every 100ms with the clickCount.
        vertx.setPeriodic(100, t -> webSocket.writeTextMessage("" + clickCount));

    }
    
}
