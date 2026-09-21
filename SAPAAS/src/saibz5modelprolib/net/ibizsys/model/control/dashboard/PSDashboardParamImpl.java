/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDashboardParam
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSMDAjaxControlParamImpl;
import net.ibizsys.model.control.dashboard.IPSDashboardParam;

public class PSDashboardParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDashboardParam {
    private double[] columnModels = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSDashboardParam iPSDashboardParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDashboardParam && (iPSDashboardParam = (IPSDashboardParam)iPSControlParam).getColumnModels() != null) {
            this.setColumnModels(iPSDashboardParam.getColumnModels());
        }
    }

    public double[] getColumnModels() {
        return this.columnModels;
    }

    public void setColumnModels(double[] columnModels) {
        this.columnModels = columnModels;
    }
}

