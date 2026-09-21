/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEToolbarParamImpl
extends PSControlParamImpl
implements IPSDEToolbarParam {
    private String strPSDEToolbarId = "";
    private String strPSDEUIActionGroupId = "";
    private String strNo2PSDEUIActionGroupId = "";
    private String strNo3PSDEUIActionGroupId = "";
    private String strNo4PSDEUIActionGroupId = "";
    private String strNo5PSDEUIActionGroupId = "";
    private String strNo6PSDEUIActionGroupId = "";
    private String strToolbarStyle = "";
    private Object objOwner = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEToolbarId(this.psDEViewCtrl.getPSDETOOLBARID());
        this.setPSDEUIActionGroupId(this.psDEViewCtrl.getPSDEUAGROUPID());
        this.setNo2PSDEUIActionGroupId(this.psDEViewCtrl.getNO2PSDEUAGROUPID());
        this.setNo3PSDEUIActionGroupId(this.psDEViewCtrl.getNO3PSDEUAGROUPID());
        this.setNo4PSDEUIActionGroupId(this.psDEViewCtrl.getNO4PSDEUAGROUPID());
        this.setNo5PSDEUIActionGroupId(this.psDEViewCtrl.getNO5PSDEUAGROUPID());
        this.setNo6PSDEUIActionGroupId(this.psDEViewCtrl.getNO6PSDEUAGROUPID());
        this.setToolbarStyle(this.psDEViewCtrl.getCTRLPARAM3());
    }

    @Override
    public String getPSDEToolbarId() {
        return this.strPSDEToolbarId;
    }

    public void setPSDEToolbarId(String strPSDEToolbarId) {
        this.strPSDEToolbarId = strPSDEToolbarId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEToolbarParam) {
            IPSDEToolbarParam iPSDEToolbarParam = (IPSDEToolbarParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getPSDEToolbarId())) {
                this.setPSDEToolbarId(iPSDEToolbarParam.getPSDEToolbarId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getPSDEUIActionGroupId())) {
                this.setPSDEUIActionGroupId(iPSDEToolbarParam.getPSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getNo2PSDEUIActionGroupId())) {
                this.setNo2PSDEUIActionGroupId(iPSDEToolbarParam.getNo2PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getNo3PSDEUIActionGroupId())) {
                this.setNo3PSDEUIActionGroupId(iPSDEToolbarParam.getNo3PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getNo4PSDEUIActionGroupId())) {
                this.setNo4PSDEUIActionGroupId(iPSDEToolbarParam.getNo4PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getNo5PSDEUIActionGroupId())) {
                this.setNo5PSDEUIActionGroupId(iPSDEToolbarParam.getNo5PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getNo6PSDEUIActionGroupId())) {
                this.setNo6PSDEUIActionGroupId(iPSDEToolbarParam.getNo6PSDEUIActionGroupId());
            }
            if (!StringHelper.IsNullOrEmpty((String)iPSDEToolbarParam.getToolbarStyle())) {
                this.setToolbarStyle(iPSDEToolbarParam.getToolbarStyle());
            }
            if (iPSDEToolbarParam.getOwner() != null) {
                this.setOwner(iPSDEToolbarParam.getOwner());
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

    @Override
    public String getToolbarStyle() {
        return this.strToolbarStyle;
    }

    public void setToolbarStyle(String strToolbarStyle) {
        this.strToolbarStyle = strToolbarStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u680f\u6240\u6709\u8005", outputdoc="false")
    public Object getOwner() {
        return this.objOwner;
    }

    public void setOwner(Object objOwner) {
        this.objOwner = objOwner;
    }
}

