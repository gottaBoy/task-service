/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.FilterConfig
 */
package org.jasig.cas.client.validation;

import javax.servlet.FilterConfig;
import org.jasig.cas.client.validation.AbstractTicketValidationFilter;
import org.jasig.cas.client.validation.Cas10TicketValidator;
import org.jasig.cas.client.validation.TicketValidator;

public class Cas10TicketValidationFilter
extends AbstractTicketValidationFilter {
    @Override
    protected final TicketValidator getTicketValidator(FilterConfig filterConfig) {
        String casServerUrlPrefix = this.getPropertyFromInitParams(filterConfig, "casServerUrlPrefix", null);
        Cas10TicketValidator validator = new Cas10TicketValidator(casServerUrlPrefix);
        validator.setRenew(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "renew", "false")));
        return validator;
    }
}

