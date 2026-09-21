/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSSysDashboardParam;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDashboardParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSSysDashboardParamImpl
extends PSDashboardParamImpl
implements IPSSysDashboardParam {
    private String strPSSysDashboardId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysDashboardId(this.psDEViewCtrl.getPSSYSDASHBOARDID());
        if (!this.psDEViewCtrl.isCTRLPARAM7Null()) {
            this.setEnableCustomized(this.psDEViewCtrl.getCTRLPARAM7() > 0);
            if (this.isEnableCustomized().booleanValue()) {
                this.setCustomizeMode(this.psDEViewCtrl.getCTRLPARAM7());
            }
        }
    }

    @Override
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
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysDashboardId())) {
                this.setPSSysDashboardId(iPSSysDashboardBarParam.getPSSysDashboardId());
            }
        }
    }
}

