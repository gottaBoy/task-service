/*
 * Decompiled with CFR 0.152.
 */
package org.jasig.cas.client.util;

import org.jasig.cas.client.validation.Assertion;

public class AssertionHolder {
    private static final ThreadLocal threadLocal = new ThreadLocal();

    public static Assertion getAssertion() {
        return (Assertion)threadLocal.get();
    }

    public static void setAssertion(Assertion assertion) {
        threadLocal.set(assertion);
    }

    public static void clear() {
        threadLocal.set(null);
    }
}

