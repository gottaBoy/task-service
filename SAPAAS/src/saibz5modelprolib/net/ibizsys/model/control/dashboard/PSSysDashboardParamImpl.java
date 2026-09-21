/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSSysDashboardParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.dashboard.IPSSysDashboardParam;
import net.ibizsys.model.control.dashboard.PSDashboardParamImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSSysDashboardParamImpl
extends PSDashboardParamImpl
implements IPSSysDashboardParam {
    private String strPSSysDashboardId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysDashboardId(this.psDEViewCtrl.getPSSYSDASHBOARDID());
    }

    public String getPSSysDashboardId() {
        return this.strPSSysDashboardId;
    }

    public void setPSSysDashboardId(String strPSSysDashboardId) {
        this.strPSSysDashboardId = strPSSysDashboardId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSSysDashboardParam) {
            IPSSysDashboardParam iPSSysDashboardBarParam = (IPSSysDashboardParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSSysDashboardId())) {
                this.setPSSysDashboardId(iPSSysDashboardBarParam.getPSSysDashboardId());
            }
        }
    }
}

