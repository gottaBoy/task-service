/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;

public interface TicketValidator {
    public Assertion validate(String var1, String var2) throws TicketValidationException;
}

