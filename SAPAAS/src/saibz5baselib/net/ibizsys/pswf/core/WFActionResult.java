/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.core.CallResult;

public class WFActionResult
extends CallResult {
    private String strInstanceId = null;
    private String strReturnInfo = null;
    private String strExitStateValue = null;

    public String getInstanceId() {
        return this.strInstanceId;
    }

    public void setInstanceId(String strInstanceId) {
        this.strInstanceId = strInstanceId;
    }

    public String getReturnInfo() {
        return this.strReturnInfo;
    }

    public void setReturnInfo(String strReturnInfo) {
        this.strReturnInfo = strReturnInfo;
    }

    public String getExitStateValue() {
        return this.strExitStateValue;
    }

    public void setExitStateValue(String strExitStateValue) {
        this.strExitStateValue = strExitStateValue;
    }
}

