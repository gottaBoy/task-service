/*
 * Copyright 2007 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.ja-sig.org/products/cas/overview/license/index.html
 *
 * Adapted from cas-client-core 3.1.12 for the locally recovered CAS base:
 * hostnameVerifier and CommonUtils.formatForUtcTime are not present here.
 */
package org.jasig.cas.client.validation;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.authentication.AttributePrincipalImpl;
import org.opensaml.SAMLAssertion;
import org.opensaml.SAMLAttribute;
import org.opensaml.SAMLAttributeStatement;
import org.opensaml.SAMLAuthenticationStatement;
import org.opensaml.SAMLException;
import org.opensaml.SAMLResponse;
import org.opensaml.SAMLStatement;
import org.opensaml.SAMLSubject;

public final class Saml11TicketValidator extends AbstractUrlBasedTicketValidator {
    private long tolerance = 1000L;

    public Saml11TicketValidator(String casServerUrlPrefix) {
        super(casServerUrlPrefix);
    }

    @Override
    protected String getUrlSuffix() {
        return "samlValidate";
    }

    @Override
    protected void populateUrlAttributeMap(Map urlParameters) {
        String service = (String) urlParameters.get("service");
        urlParameters.remove("service");
        urlParameters.remove("ticket");
        urlParameters.put("TARGET", service);
    }

    @Override
    protected Assertion parseResponseFromServer(String response) throws TicketValidationException {
        try {
            int start = response.indexOf("<SOAP-ENV:Body>");
            int end = response.indexOf("</SOAP-ENV:Body>");
            if (start < 0 || end <= start) {
                throw new TicketValidationException("No SOAP body found in SAML response.");
            }
            String body = response.substring(start + "<SOAP-ENV:Body>".length(), end);
            SAMLResponse samlResponse = new SAMLResponse(new ByteArrayInputStream(body.getBytes("UTF-8")));

            if (!samlResponse.getAssertions().hasNext()) {
                throw new TicketValidationException("No assertions found.");
            }

            for (Iterator iter = samlResponse.getAssertions(); iter.hasNext();) {
                SAMLAssertion assertion = (SAMLAssertion) iter.next();
                if (!isValidAssertion(assertion)) {
                    continue;
                }

                SAMLAuthenticationStatement authenticationStatement = getSAMLAuthenticationStatement(assertion);
                if (authenticationStatement == null) {
                    throw new TicketValidationException("No AuthenticationStatement found in SAML Assertion.");
                }
                SAMLSubject subject = authenticationStatement.getSubject();
                if (subject == null || subject.getNameIdentifier() == null) {
                    throw new TicketValidationException("No Subject found in SAML Assertion.");
                }

                Map personAttributes = new HashMap();
                SAMLAttribute[] attributes = getAttributesFor(assertion, subject);
                for (int i = 0; i < attributes.length; i++) {
                    SAMLAttribute attribute = attributes[i];
                    List values = getValuesFrom(attribute);
                    personAttributes.put(attribute.getName(), values.size() == 1 ? values.get(0) : values);
                }

                AttributePrincipal principal = new AttributePrincipalImpl(subject.getNameIdentifier().getName(), personAttributes);
                Map authenticationAttributes = new HashMap();
                authenticationAttributes.put("samlAuthenticationStatement::authMethod", authenticationStatement.getAuthMethod());
                return new AssertionImpl(principal, authenticationAttributes);
            }
        } catch (SAMLException e) {
            throw new TicketValidationException(e);
        } catch (IOException e) {
            throw new TicketValidationException(e);
        }
        throw new TicketValidationException("No Assertion found within valid time range.");
    }

    private boolean isValidAssertion(SAMLAssertion assertion) {
        Date notBefore = assertion.getNotBefore();
        Date notOnOrAfter = assertion.getNotOnOrAfter();
        if (notBefore == null || notOnOrAfter == null) {
            return false;
        }
        long now = System.currentTimeMillis();
        return now + tolerance >= notBefore.getTime() && notOnOrAfter.getTime() > now - tolerance;
    }

    private SAMLAuthenticationStatement getSAMLAuthenticationStatement(SAMLAssertion assertion) {
        for (Iterator iter = assertion.getStatements(); iter.hasNext();) {
            SAMLStatement statement = (SAMLStatement) iter.next();
            if (statement instanceof SAMLAuthenticationStatement) {
                return (SAMLAuthenticationStatement) statement;
            }
        }
        return null;
    }

    private SAMLAttribute[] getAttributesFor(SAMLAssertion assertion, SAMLSubject subject) {
        List attributes = new ArrayList();
        for (Iterator iter = assertion.getStatements(); iter.hasNext();) {
            SAMLStatement statement = (SAMLStatement) iter.next();
            if (statement instanceof SAMLAttributeStatement) {
                SAMLAttributeStatement attributeStatement = (SAMLAttributeStatement) statement;
                if (attributeStatement.getSubject() != null
                        && attributeStatement.getSubject().getNameIdentifier() != null
                        && subject.getNameIdentifier().getName().equals(
                                attributeStatement.getSubject().getNameIdentifier().getName())) {
                    for (Iterator values = attributeStatement.getAttributes(); values.hasNext();) {
                        attributes.add(values.next());
                    }
                }
            }
        }
        return (SAMLAttribute[]) attributes.toArray(new SAMLAttribute[attributes.size()]);
    }

    private List getValuesFrom(SAMLAttribute attribute) {
        List values = new ArrayList();
        for (Iterator iter = attribute.getValues(); iter.hasNext();) {
            values.add(iter.next());
        }
        return values;
    }

    @Override
    protected String retrieveResponseFromServer(URL validationUrl, String ticket) {
        DateFormat utc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        utc.setTimeZone(TimeZone.getTimeZone("UTC"));
        String request = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<SOAP-ENV:Header/><SOAP-ENV:Body>"
                + "<samlp:Request xmlns:samlp=\"urn:oasis:names:tc:SAML:1.0:protocol\" MajorVersion=\"1\""
                + " MinorVersion=\"1\" RequestID=\"" + UUID.randomUUID().toString()
                + "\" IssueInstant=\"" + utc.format(new Date()) + "\"><samlp:AssertionArtifact>"
                + escapeXml(ticket) + "</samlp:AssertionArtifact></samlp:Request></SOAP-ENV:Body></SOAP-ENV:Envelope>";

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) validationUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/xml");
            connection.setRequestProperty("SOAPAction", "http://www.oasis-open.org/committees/security");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            try {
                out.write(request.getBytes("UTF-8"));
            } finally {
                out.close();
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            try {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public void setTolerance(long tolerance) {
        this.tolerance = tolerance;
    }

    private static String escapeXml(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
    }
}
