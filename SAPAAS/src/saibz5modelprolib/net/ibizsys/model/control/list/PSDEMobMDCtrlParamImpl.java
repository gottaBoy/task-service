/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.list.IPSDEMobMDCtrlParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.list.IPSDEMobMDCtrlParam;
import net.ibizsys.model.control.list.PSDEListParamImpl;
import net.ibizsys.paas.util.StringHelper;

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

    public String getControlSubType() {
        return this.strControlSubType;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEMobMDCtrlParam) {
            IPSDEMobMDCtrlParam iPSDEMobMDCtrlParam = (IPSDEMobMDCtrlParam)iPSControlParam;
            if (!StringHelper.isNullOrEmpty((String)iPSDEMobMDCtrlParam.getPSDEUIActionGroupId())) {
                this.setPSDEUIActionGroupId(iPSDEMobMDCtrlParam.getPSDEUIActionGroupId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo2PSDEUIActionGroupId())) {
                this.setNo2PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo2PSDEUIActionGroupId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo3PSDEUIActionGroupId())) {
                this.setNo3PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo3PSDEUIActionGroupId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo4PSDEUIActionGroupId())) {
                this.setNo4PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo4PSDEUIActionGroupId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo5PSDEUIActionGroupId())) {
                this.setNo5PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo5PSDEUIActionGroupId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEMobMDCtrlParam.getNo6PSDEUIActionGroupId())) {
                this.setNo6PSDEUIActionGroupId(iPSDEMobMDCtrlParam.getNo6PSDEUIActionGroupId());
            }
        }
    }

    public String getPSDEUIActionGroupId() {
        return this.strPSDEUIActionGroupId;
    }

    public String getNo2PSDEUIActionGroupId() {
        return this.strNo2PSDEUIActionGroupId;
    }

    public String getNo3PSDEUIActionGroupId() {
        return this.strNo3PSDEUIActionGroupId;
    }

    public String getNo4PSDEUIActionGroupId() {
        return this.strNo4PSDEUIActionGroupId;
    }

    public String getNo5PSDEUIActionGroupId() {
        return this.strNo5PSDEUIActionGroupId;
    }

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

