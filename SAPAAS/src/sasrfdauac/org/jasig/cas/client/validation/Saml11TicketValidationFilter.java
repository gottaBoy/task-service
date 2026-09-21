/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.FilterConfig
 *  org.jasig.cas.client.validation.Saml11TicketValidator
 */
package org.jasig.cas.client.validation;

import javax.servlet.FilterConfig;
import org.jasig.cas.client.validation.AbstractTicketValidationFilter;
import org.jasig.cas.client.validation.Saml11TicketValidator;
import org.jasig.cas.client.validation.TicketValidator;

public class Saml11TicketValidationFilter
extends AbstractTicketValidationFilter {
    public Saml11TicketValidationFilter() {
        this.setArtifactParameterName("SAMLart");
        this.setServiceParameterName("TARGET");
    }

    @Override
    protected final TicketValidator getTicketValidator(FilterConfig filterConfig) {
        Saml11TicketValidator validator = new Saml11TicketValidator(this.getPropertyFromInitParams(filterConfig, "casServerUrlPrefix", null));
        String tolerance = this.getPropertyFromInitParams(filterConfig, "tolerance", "1000");
        validator.setTolerance(Long.parseLong(tolerance));
        validator.setRenew(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "renew", "false")));
        return validator;
    }
}

