/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.exception.ErrorException;

public class RestCallException
extends ErrorException {
    private int nStatusCode = 200;

    public RestCallException(int nStatusCode) {
        super(0);
        this.nStatusCode = nStatusCode;
    }

    public RestCallException(int nErrorCode, String strMessage) {
        super(nErrorCode, strMessage);
    }

    public int getStatusCode() {
        return this.nStatusCode;
    }

    public boolean isStatusCodeOk() {
        return this.getStatusCode() == 200;
    }
}

