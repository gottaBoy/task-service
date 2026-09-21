/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

public class WFException
extends Exception {
    private static final long serialVersionUID = 1L;
    private int nErrorCode = 0;

    public WFException(int nErrorCode, String strMessage) {
        super(strMessage);
        this.nErrorCode = nErrorCode;
    }

    public WFException(String strMessage) {
        super(strMessage);
        this.nErrorCode = 999999;
    }

    public int getErrorCode() {
        return this.nErrorCode;
    }
}

