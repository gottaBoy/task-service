/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import org.jasig.cas.client.validation.TicketValidationException;

public final class InvalidProxyChainTicketValidationException
extends TicketValidationException {
    private static final long serialVersionUID = -7736653266370691534L;

    public InvalidProxyChainTicketValidationException(String string) {
        super(string);
    }

    public InvalidProxyChainTicketValidationException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public InvalidProxyChainTicketValidationException(Throwable throwable) {
        super(throwable);
    }
}

