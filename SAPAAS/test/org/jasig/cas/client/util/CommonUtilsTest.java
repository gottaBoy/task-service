package org.jasig.cas.client.util;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import junit.framework.TestCase;

public class CommonUtilsTest extends TestCase {
    public void testHttpResponseAndServerFailure() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/ok", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                byte[] body = "first\nsecond".getBytes("UTF-8");
                exchange.sendResponseHeaders(200, body.length);
                try {
                    exchange.getResponseBody().write(body);
                } finally {
                    exchange.close();
                }
            }
        });
        server.createContext("/error", new HttpHandler() {
            public void handle(HttpExchange exchange) throws IOException {
                exchange.sendResponseHeaders(500, -1);
                exchange.close();
            }
        });
        server.start();
        try {
            String base = "http://127.0.0.1:" + server.getAddress().getPort();
            assertEquals("first\nsecond\n", CommonUtils.getResponseFromServer(new URL(base + "/ok")));
            try {
                CommonUtils.getResponseFromServer(new URL(base + "/error"));
                fail("HTTP failure should not produce an empty CAS response");
            } catch (RuntimeException expected) {
                assertTrue(expected.getCause() instanceof IOException);
            }
        } finally {
            server.stop(0);
        }
    }
}
