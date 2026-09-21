/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.core;

import net.ibizsys.pscore.srv.core.PSException;

public class PSDCSysLicException
extends PSException {
    private static final long serialVersionUID = 1L;
    private String strLicName = null;
    private int nLicCount = 0;
    private int nCurCount = 0;

    public PSDCSysLicException(String string) {
        super(string);
    }

    public PSDCSysLicException(String string, String string2, int n, int n2) {
        super(string);
        this.strLicName = string2;
        this.nLicCount = n;
        this.nCurCount = n2;
    }

    public String getLicName() {
        return this.strLicName;
    }

    public int getLicCount() {
        return this.nLicCount;
    }

    public int getCurCount() {
        return this.nCurCount;
    }
}

