/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEDataImportResult;

public class DEDataImportResult
implements IDEDataImportResult {
    private String strRetInfo = null;
    private int nRetCode = 0;
    private int nRowSN = 0;

    @Override
    public String getRetInfo() {
        return this.strRetInfo;
    }

    @Override
    public int getRetCode() {
        return this.nRetCode;
    }

    public void setRetInfo(String strRetInfo) {
        this.strRetInfo = strRetInfo;
    }

    public void setRetCode(int nRetCode) {
        this.nRetCode = nRetCode;
    }

    @Override
    public int getRowSN() {
        return this.nRowSN;
    }

    public void setRowSN(int nRowSN) {
        this.nRowSN = nRowSN;
    }
}

