/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Custom;

import SA.SRFDA.PS.Core.Control.Custom.IPSCustomControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSCustomControlParamImpl
extends PSAjaxControlParamImpl
implements IPSCustomControlParam {
    private String strPSSysPFPluginId = "";
    private String strPSDEActionId = "";
    private String strPSDEDataSetId = "";

    @Override
    protected void onInit() throws Exception {
        this.setPSSysPFPluginId(this.psDEViewCtrl.getPSSYSPFPLUGINID());
        this.setPSDEActionId(this.psDEViewCtrl.getPSDEACTIONID());
        this.setPSDEDataSetId(this.psDEViewCtrl.getPSDEDATASETID());
        super.onInit();
    }

    @Override
    public String getPSSysPFPluginId() {
        return this.strPSSysPFPluginId;
    }

    @Override
    public void setPSSysPFPluginId(String strPSSysPFPluginId) {
        this.strPSSysPFPluginId = strPSSysPFPluginId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSCustomControlParam) {
            IPSCustomControlParam iPSDEViewBarParam = (IPSCustomControlParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysPFPluginId())) {
                this.setPSSysPFPluginId(iPSDEViewBarParam.getPSSysPFPluginId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEActionId())) {
                this.setPSDEActionId(iPSDEViewBarParam.getPSDEActionId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEDataSetId())) {
                this.setPSDEDataSetId(iPSDEViewBarParam.getPSDEDataSetId());
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
    public String getPSDEDataSetId() {
        return this.strPSDEDataSetId;
    }

    protected void setPSDEDataSetId(String strPSDEDataSetId) {
        this.strPSDEDataSetId = strPSDEDataSetId;
    }
}

