/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.jasig.cas.client.validation.AbstractCasProtocolUrlBasedTicketValidator;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.AssertionImpl;
import org.jasig.cas.client.validation.TicketValidationException;

public final class Cas10TicketValidator
extends AbstractCasProtocolUrlBasedTicketValidator {
    public Cas10TicketValidator(String casServerUrlPrefix) {
        super(casServerUrlPrefix);
    }

    @Override
    protected String getUrlSuffix() {
        return "validate";
    }

    @Override
    protected Assertion parseResponseFromServer(String response) throws TicketValidationException {
        if (!response.startsWith("yes")) {
            throw new TicketValidationException("CAS Server could not validate ticket.");
        }
        try {
            BufferedReader reader = new BufferedReader(new StringReader(response));
            reader.readLine();
            String name = reader.readLine();
            return new AssertionImpl(name);
        }
        catch (IOException e) {
            throw new TicketValidationException("Unable to parse response.", e);
        }
    }
}

