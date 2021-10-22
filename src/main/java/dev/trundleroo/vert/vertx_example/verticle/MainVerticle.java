package dev.trundleroo.vert.vertx_example.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class MainVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);

    @Override
    public void start() {
        vertx.deployVerticle(ApiVerticle.class.getName());
        LOGGER.info("API Verticle deployed successfully.");
    }

  
}
