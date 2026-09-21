/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import java.net.URL;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.AbstractUrlBasedTicketValidator;

public abstract class AbstractCasProtocolUrlBasedTicketValidator
extends AbstractUrlBasedTicketValidator {
    protected AbstractCasProtocolUrlBasedTicketValidator(String casServerUrlPrefix) {
        super(casServerUrlPrefix);
    }

    @Override
    protected final String retrieveResponseFromServer(URL validationUrl, String ticket) {
        return CommonUtils.getResponseFromServer(validationUrl);
    }
}

