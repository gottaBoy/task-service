/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.data.DataObject;

public class CallArg {
    private String strActionMode;
    private DataObject dataObject;

    public String getActionMode() {
        return this.strActionMode;
    }

    public void setActionMode(String strActionMode) {
        this.strActionMode = strActionMode;
    }

    public DataObject getDataObject() {
        return this.dataObject;
    }

    public void setDataObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }
}

