/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import org.jasig.cas.client.authentication.AttributePrincipal;

public interface Assertion
extends Serializable {
    public Date getValidFromDate();

    public Date getValidUntilDate();

    public Map getAttributes();

    public AttributePrincipal getPrincipal();
}

