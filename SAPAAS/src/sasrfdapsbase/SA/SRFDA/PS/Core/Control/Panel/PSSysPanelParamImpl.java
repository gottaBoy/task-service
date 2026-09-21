/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelParam;
import SA.SRFramework.Utility.StringHelper;

public class PSSysPanelParamImpl
extends PSControlParamImpl
implements IPSSysPanelParam {
    private String strPSSysPanelId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysPanelId(this.psDEViewCtrl.getPSSYSVIEWPANELID());
    }

    @Override
    public String getPSSysPanelId() {
        return this.strPSSysPanelId;
    }

    public void setPSSysPanelId(String strPSSysPanelId) {
        this.strPSSysPanelId = strPSSysPanelId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSSysPanelParam iPSSysPanelParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSSysPanelParam && !StringHelper.IsNullOrEmpty((String)(iPSSysPanelParam = (IPSSysPanelParam)iPSControlParam).getPSSysPanelId())) {
            this.setPSSysPanelId(iPSSysPanelParam.getPSSysPanelId());
        }
    }
}

