package com.gdiama;


import com.gdiama.infrastructure.configuration.ProductionContext;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.DefaultHandler;
import org.mortbay.jetty.handler.HandlerCollection;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URL;

import static java.lang.Integer.valueOf;
import static java.lang.System.getenv;

//todo make this work
public class LiquidityServer {

    private static Server server;
    private static final String CONTEXT = "liquidity";


    public LiquidityServer() throws IOException {
        server = new Server(valueOf(getenv("PORT")));

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ProductionContext.class);
        applicationContext.refresh();

        URL resource = this.getClass().getClassLoader().getResource("webapp");
        String webapp = resource.toExternalForm();

        WebAppContext handler = new WebAppContext(webapp, CONTEXT);
        handler.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, applicationContext);
        handler.setResourceBase(webapp);

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{handler, new DefaultHandler()});
        server.addHandler(handlers);
    }

    public void start() {
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException("Error while starting server", e);
        }
    }

    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            throw new RuntimeException("Error while stopping server", e);
        }
    }


    public static void main(String[] args) {
        try {
            LiquidityServer liquidityServer = new LiquidityServer();
            liquidityServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
