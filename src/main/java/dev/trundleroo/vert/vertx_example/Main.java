package dev.trundleroo.vert.vertx_example;

import dev.trundleroo.vert.vertx_example.verticle.MainVerticle;
import io.vertx.core.Vertx;

public class Main {
    
    public static void main(String[] args) {

        final Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MainVerticle.class.getName());

    }

}
