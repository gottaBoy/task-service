/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.exception;

import net.ibizsys.paas.exception.ErrorException;

public class AccessDenyException
extends ErrorException {
    private static final long serialVersionUID = 1L;
    private boolean bNotLogin = true;

    public AccessDenyException(String strMessage, boolean bNotLogin) {
        super(2, strMessage);
        this.bNotLogin = bNotLogin;
    }

    public boolean isNotLogin() {
        return this.bNotLogin;
    }

    public void setNotLogin(boolean bNotLogin) {
        this.bNotLogin = bNotLogin;
    }
}

