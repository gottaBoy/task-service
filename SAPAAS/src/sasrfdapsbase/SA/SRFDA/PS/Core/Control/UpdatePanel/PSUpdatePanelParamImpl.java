/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.UpdatePanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.Control.UpdatePanel.IPSUpdatePanelParam;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelIgnoreMeta
public class PSUpdatePanelParamImpl
extends PSControlParamImpl
implements IPSUpdatePanelParam {
    private String strPSSysMsgTemplId = "";
    private String strPSDEActionId = "";
    private Integer nTimer = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysMsgTemplId(this.psDEViewCtrl.getPSSYSMSGTEMPLID());
        this.setPSDEActionId(this.psDEViewCtrl.getPSDEACTIONID());
        if (!this.psDEViewCtrl.isCTRLPARAM7Null() && this.psDEViewCtrl.getCTRLPARAM7() > 0) {
            this.nTimer = this.psDEViewCtrl.getCTRLPARAM7();
        }
    }

    @Override
    public String getPSSysMsgTemplId() {
        return this.strPSSysMsgTemplId;
    }

    public void setPSSysMsgTemplId(String strPSSysMsgTemplId) {
        this.strPSSysMsgTemplId = strPSSysMsgTemplId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSUpdatePanelParam) {
            IPSUpdatePanelParam iPSDEViewBarParam = (IPSUpdatePanelParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysMsgTemplId())) {
                this.setPSSysMsgTemplId(iPSDEViewBarParam.getPSSysMsgTemplId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEActionId())) {
                this.setPSDEActionId(iPSDEViewBarParam.getPSDEActionId());
            }
            if (this.getTimer() == null) {
                this.setTimer(iPSDEViewBarParam.getTimer());
            }
        }
    }

    @Override
    public String getPSDEActionId() {
        return this.strPSDEActionId;
    }

    protected void setPSDEActionId(String strPSDEActionId) {
        this.strPSDEActionId = strPSDEActionId;
    }

    @Override
    public Integer getTimer() {
        return this.nTimer;
    }

    protected void setTimer(Integer nTimer) {
        this.nTimer = nTimer;
    }
}

