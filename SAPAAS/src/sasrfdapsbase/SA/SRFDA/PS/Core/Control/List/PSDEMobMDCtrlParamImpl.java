/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.List.IPSDEMobMDCtrlParam;
import SA.SRFDA.PS.Core.Control.List.PSDEListParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEMobMDCtrlParamImpl
extends PSDEListParamImpl
implements IPSDEMobMDCtrlParam {
    private String strControlSubType = null;
    private String strPSDEUIActionGroupId = "";
    private String strNo2PSDEUIActionGroupId = "";
    private String strNo3PSDEUIActionGroupId = "";
    private String strNo4PSDEUIActionGroupId = "";
    private String strNo5PSDEUIActionGroupId = "";
    private String strNo6PSDEUIActionGroupId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEUIActionGroupId(this.psDEViewCtrl.getPSDEUAGROUPID());
        this.setNo2PSDEUIActionGroupId(this.psDEViewCtrl.getNO2PSDEUAGROUPID());
        this.setNo3PSDEUIActionGroupId(this.psDEViewCtrl.getNO3PSDEUAGROUPID());
        this.setNo4PSDEUIActionGroupId(this.psDEViewCtrl.getNO4PSDEUAGROUPID());
        this.setNo5PSDEUIActionGroupId(this.psDEViewCtrl.getNO5PSDEUAGROUPID());
        this.setNo6PSDEUIActionGroupId(this.psDEViewCtrl.getNO6PSDEUAGROUPID());
    }

    @Override
    public String getControlSubType() {
        return this.strControlSubType;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEMobMDCtrlParam) {
            IPSDEMobMDCtrlParam iPSDEMobMDCtrlParam = (IPSDEMobMDCtrlParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)iPSDEMobMDCtrlParam.getPSDEUIActionGroupId())) {
                this.setPSDEUIActionGroupId(iPSDEMobMDCtrlParam.getPSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo2PSDEUIActionGroupId())) {
                this.setNo2PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo2PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo3PSDEUIActionGroupId())) {
                this.setNo3PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo3PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo4PSDEUIActionGroupId())) {
                this.setNo4PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo4PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo5PSDEUIActionGroupId())) {
                this.setNo5PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo5PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo6PSDEUIActionGroupId())) {
                this.setNo6PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo6PSDEUIActionGroupId());
            }
        }
    }

    @Override
    public String getPSDEUIActionGroupId() {
        return this.strPSDEUIActionGroupId;
    }

    @Override
    public String getNo2PSDEUIActionGroupId() {
        return this.strNo2PSDEUIActionGroupId;
    }

    @Override
    public String getNo3PSDEUIActionGroupId() {
        return this.strNo3PSDEUIActionGroupId;
    }

    @Override
    public String getNo4PSDEUIActionGroupId() {
        return this.strNo4PSDEUIActionGroupId;
    }

    @Override
    public String getNo5PSDEUIActionGroupId() {
        return this.strNo5PSDEUIActionGroupId;
    }

    @Override
    public String getNo6PSDEUIActionGroupId() {
        return this.strNo6PSDEUIActionGroupId;
    }

    public void setPSDEUIActionGroupId(String strPSDEUIActionGroupId) {
        this.strPSDEUIActionGroupId = strPSDEUIActionGroupId;
    }

    public void setNo2PSDEUIActionGroupId(String strNo2PSDEUIActionGroupId) {
        this.strNo2PSDEUIActionGroupId = strNo2PSDEUIActionGroupId;
    }

    public void setNo3PSDEUIActionGroupId(String strNo3PSDEUIActionGroupId) {
        this.strNo3PSDEUIActionGroupId = strNo3PSDEUIActionGroupId;
    }

    public void setNo4PSDEUIActionGroupId(String strNo4PSDEUIActionGroupId) {
        this.strNo4PSDEUIActionGroupId = strNo4PSDEUIActionGroupId;
    }

    public void setNo5PSDEUIActionGroupId(String strNo5PSDEUIActionGroupId) {
        this.strNo5PSDEUIActionGroupId = strNo5PSDEUIActionGroupId;
    }

    public void setNo6PSDEUIActionGroupId(String strNo6PSDEUIActionGroupId) {
        this.strNo6PSDEUIActionGroupId = strNo6PSDEUIActionGroupId;
    }
}

