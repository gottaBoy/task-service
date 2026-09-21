/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.validation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.authentication.AttributePrincipalImpl;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;

public final class AssertionImpl
implements Assertion {
    private static final long serialVersionUID = -7767943925833639221L;
    private final Date validFromDate;
    private final Date validUntilDate;
    private final Map attributes;
    private final AttributePrincipal principal;

    public AssertionImpl(String name) {
        this(new AttributePrincipalImpl(name));
    }

    public AssertionImpl(AttributePrincipal principal) {
        this(principal, new HashMap());
    }

    public AssertionImpl(AttributePrincipal principal, Map attributes) {
        this(principal, new Date(), null, attributes);
    }

    public AssertionImpl(AttributePrincipal principal, Date validFromDate, Date validUntilDate, Map attributes) {
        this.principal = principal;
        this.validFromDate = validFromDate;
        this.validUntilDate = validUntilDate;
        this.attributes = attributes;
        CommonUtils.assertNotNull(this.principal, "principal cannot be null.");
        CommonUtils.assertNotNull(this.validFromDate, "validFromDate cannot be null.");
        CommonUtils.assertNotNull(this.attributes, "attributes cannot be null.");
    }

    @Override
    public Date getValidFromDate() {
        return this.validFromDate;
    }

    @Override
    public Date getValidUntilDate() {
        return this.validUntilDate;
    }

    @Override
    public Map getAttributes() {
        return this.attributes;
    }

    @Override
    public AttributePrincipal getPrincipal() {
        return this.principal;
    }
}

