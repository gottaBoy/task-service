/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IReportModel;

public abstract class ReportModelBase
extends CtrlModelBase
implements IReportModel {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getControlType() {
        return "REPORT";
    }
}

