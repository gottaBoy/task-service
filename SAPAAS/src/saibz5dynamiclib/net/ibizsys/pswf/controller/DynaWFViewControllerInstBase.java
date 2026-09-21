/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.controller;

import net.ibizsys.paas.controller.DynaViewControllerInstBase;
import net.ibizsys.pswf.controller.IDynaWFViewControllerInst;

public abstract class DynaWFViewControllerInstBase
extends DynaViewControllerInstBase
implements IDynaWFViewControllerInst {
    private boolean bWFIAMode = false;
    private String strWFStepValue = null;

    public boolean isWFIAMode() {
        return this.bWFIAMode;
    }

    public String getWFStepValue() {
        return this.strWFStepValue;
    }

    public void setWFIAMode(boolean bWFIAMode) {
        this.bWFIAMode = bWFIAMode;
    }

    public void setWFStepValue(String strWFStepValue) {
        this.strWFStepValue = strWFStepValue;
    }
}

