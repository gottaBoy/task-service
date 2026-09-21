/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDETreeParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDETreeParam {
    private String strPSDETreeId = "";
    private Boolean bSingleSelect = null;
    private String strPSSysCounterId = "";
    private Boolean bEnableEdit = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDETreeId(this.psDEViewCtrl.getPSDETREEVIEWID());
        this.setPSSysCounterId(this.psDEViewCtrl.getPSSYSCOUNTERID());
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.setEnableEdit(this.psDEViewCtrl.getCTRLPARAM6());
        }
    }

    @Override
    public String getPSDETreeId() {
        return this.strPSDETreeId;
    }

    public void setPSDETreeId(String strPSDETreeId) {
        this.strPSDETreeId = strPSDETreeId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDETreeParam) {
            IPSDETreeParam iPSDETreeParam = (IPSDETreeParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)iPSDETreeParam.getPSDETreeId())) {
                this.setPSDETreeId(iPSDETreeParam.getPSDETreeId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDETreeParam.getPSSysCounterId())) {
                this.setPSSysCounterId(iPSDETreeParam.getPSSysCounterId());
            }
            if (iPSDETreeParam.isEnableEdit() != null) {
                this.setEnableEdit(iPSDETreeParam.isEnableEdit());
            }
        }
    }

    @Override
    public String getPSSysCounterId() {
        return this.strPSSysCounterId;
    }

    public void setPSSysCounterId(String strPSSysCounterId) {
        this.strPSSysCounterId = strPSSysCounterId;
    }

    @Override
    public Boolean isEnableEdit() {
        if (this.bEnableEdit == null) {
            return null;
        }
        return this.bEnableEdit;
    }

    public void setEnableEdit(Boolean bEnableEdit) {
        this.bEnableEdit = bEnableEdit;
    }
}

