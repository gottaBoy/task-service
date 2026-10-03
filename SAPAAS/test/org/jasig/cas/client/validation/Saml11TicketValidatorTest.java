package org.jasig.cas.client.validation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import junit.framework.TestCase;

public class Saml11TicketValidatorTest extends TestCase {
    private final Saml11TicketValidator validator = new Saml11TicketValidator("http://localhost/cas");

    public void testConstructValidationUrlUsesTargetAndNoTicketInQuery() {
        validator.setRenew(true);
        String url = validator.constructValidationUrl("ST-1", "https://example.org/page?a=1&b=2");
        assertTrue(url.startsWith("http://localhost/cas/samlValidate?"));
        assertTrue(url.contains("TARGET=https%3A%2F%2Fexample.org%2Fpage%3Fa%3D1%26b%3D2"));
        assertTrue(url.contains("renew=true"));
        assertFalse(url.contains("ticket="));
        assertFalse(url.contains("service="));
    }

    public void testValidSamlAssertionProvidesPrincipal() throws Exception {
        Assertion assertion = validator.parseResponseFromServer(response(System.currentTimeMillis() - 60000,
                System.currentTimeMillis() + 60000));
        assertEquals("alice", assertion.getPrincipal().getName());
        assertEquals("urn:oasis:names:tc:SAML:1.0:am:password",
                assertion.getAttributes().get("samlAuthenticationStatement::authMethod"));
    }

    public void testExpiredSamlAssertionIsRejected() throws Exception {
        try {
            validator.parseResponseFromServer(response(System.currentTimeMillis() - 120000,
                    System.currentTimeMillis() - 60000));
            fail("Expired SAML assertion was accepted");
        } catch (TicketValidationException expected) {
            assertTrue(expected.getMessage().contains("valid time range"));
        }
    }

    public void testMissingSoapBodyIsRejected() throws Exception {
        try {
            validator.parseResponseFromServer("<samlp:Response/>");
            fail("Response without SOAP body was accepted");
        } catch (TicketValidationException expected) {
            assertTrue(expected.getMessage().contains("SOAP body"));
        }
    }

    public void testPostSendsArtifactAndReadsServerAssertion() throws Exception {
        final String[] captured = new String[3];
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/cas/samlValidate", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                captured[0] = exchange.getRequestMethod();
                captured[1] = exchange.getRequestURI().getRawQuery();
                ByteArrayOutputStream body = new ByteArrayOutputStream();
                InputStream in = exchange.getRequestBody();
                byte[] bytes = new byte[1024];
                int length;
                while ((length = in.read(bytes)) != -1) {
                    body.write(bytes, 0, length);
                }
                captured[2] = body.toString("UTF-8");
                byte[] reply = response(System.currentTimeMillis() - 60000,
                        System.currentTimeMillis() + 60000).getBytes("UTF-8");
                exchange.sendResponseHeaders(200, reply.length);
                OutputStream out = exchange.getResponseBody();
                out.write(reply);
                out.close();
            }
        });
        server.start();
        try {
            Saml11TicketValidator remote = new Saml11TicketValidator(
                    "http://127.0.0.1:" + server.getAddress().getPort() + "/cas");
            assertEquals("alice", remote.validate("ART-1", "https://example.org/page").getPrincipal().getName());
            assertEquals("POST", captured[0]);
            assertTrue(captured[1].contains("TARGET=https%3A%2F%2Fexample.org%2Fpage"));
            assertFalse(captured[1].contains("ticket="));
            assertTrue(captured[2].contains("<samlp:AssertionArtifact>ART-1</samlp:AssertionArtifact>"));
            remote.retrieveResponseFromServer(new URL("http://127.0.0.1:"
                    + server.getAddress().getPort() + "/cas/samlValidate"), "ART<&\"'");
            assertTrue(captured[2].contains("<samlp:AssertionArtifact>ART&lt;&amp;&quot;&apos;"
                    + "</samlp:AssertionArtifact>"));
        } finally {
            server.stop(0);
        }
    }

    private static String date(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        return format.format(new Date(time));
    }

    private static String response(long from, long until) {
        String now = date(System.currentTimeMillis());
        return "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<SOAP-ENV:Body><samlp:Response xmlns:samlp=\"urn:oasis:names:tc:SAML:1.0:protocol\""
                + " xmlns:saml=\"urn:oasis:names:tc:SAML:1.0:assertion\" ResponseID=\"r1\""
                + " IssueInstant=\"" + now + "\" MajorVersion=\"1\" MinorVersion=\"1\">"
                + "<samlp:Status><samlp:StatusCode Value=\"samlp:Success\"/></samlp:Status>"
                + "<saml:Assertion AssertionID=\"a1\" Issuer=\"cas\" IssueInstant=\"" + now + "\""
                + " MajorVersion=\"1\" MinorVersion=\"1\"><saml:Conditions NotBefore=\"" + date(from)
                + "\" NotOnOrAfter=\"" + date(until) + "\"/>"
                + "<saml:AuthenticationStatement AuthenticationMethod=\"urn:oasis:names:tc:SAML:1.0:am:password\""
                + " AuthenticationInstant=\"" + now + "\"><saml:Subject>"
                + "<saml:NameIdentifier>alice</saml:NameIdentifier></saml:Subject>"
                + "</saml:AuthenticationStatement></saml:Assertion></samlp:Response>"
                + "</SOAP-ENV:Body></SOAP-ENV:Envelope>";
    }
}
