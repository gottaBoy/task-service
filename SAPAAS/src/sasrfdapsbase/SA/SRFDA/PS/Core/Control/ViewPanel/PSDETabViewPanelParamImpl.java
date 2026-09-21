/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDETabViewPanelParam;
import SA.SRFDA.PS.Core.Control.ViewPanel.PSDEViewPanelParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDETabViewPanelParamImpl
extends PSDEViewPanelParamImpl
implements IPSDETabViewPanelParam {
    private String strPSSysCounterId = "";
    private String strCounterId = "";
    private String strNavPSDERId = "";
    private String strNavPSDERName = "";
    private String strPSSysImageId = "";
    private String strNavFilter = "";
    private String strPSDEOPPrivId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysCounterId(this.psDEViewCtrl.getPSSYSCOUNTERID());
        this.setCounterId(this.psDEViewCtrl.getCTRLPARAM3());
        this.setNavPSDERName(this.psDEViewCtrl.getCTRLPARAM());
        this.setNavPSDERId(this.psDEViewCtrl.getCTRLPARAM2());
        this.setPSSysImageId(this.psDEViewCtrl.getPSSYSIMAGEID());
        this.setNavFilter(this.psDEViewCtrl.getCTRLPARAM4());
        this.setPSDEOPPrivId(this.psDEViewCtrl.getPSDEOPPRIVID());
    }

    @Override
    public String getPSSysCounterId() {
        return this.strPSSysCounterId;
    }

    public void setPSSysCounterId(String strPSSysCounterId) {
        this.strPSSysCounterId = strPSSysCounterId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDETabViewPanelParam) {
            IPSDETabViewPanelParam iPSDETabViewPanelParam = (IPSDETabViewPanelParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysCounterId())) {
                this.setPSSysCounterId(iPSDETabViewPanelParam.getPSSysCounterId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getCounterId())) {
                this.setCounterId(iPSDETabViewPanelParam.getCounterId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getNavFilter())) {
                this.setNavFilter(iPSDETabViewPanelParam.getNavFilter());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getNavPSDERId())) {
                this.setNavPSDERId(iPSDETabViewPanelParam.getNavPSDERId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getNavPSDERName())) {
                this.setNavPSDERName(iPSDETabViewPanelParam.getNavPSDERName());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysImageId())) {
                this.setPSSysImageId(iPSDETabViewPanelParam.getPSSysImageId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEOPPrivId())) {
                this.setPSDEOPPrivId(iPSDETabViewPanelParam.getPSDEOPPrivId());
            }
        }
    }

    @Override
    public String getCounterId() {
        return this.strCounterId;
    }

    protected void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u5173\u7cfb\u6807\u8bc6", dump=false)
    public String getNavPSDERId() {
        return this.strNavPSDERId;
    }

    protected void setNavPSDERId(String strNavPSDERId) {
        this.strNavPSDERId = strNavPSDERId;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u5173\u7cfb\u540d\u79f0")
    public String getNavPSDERName() {
        return this.strNavPSDERName;
    }

    protected void setNavPSDERName(String strNavPSDERName) {
        this.strNavPSDERName = strNavPSDERName;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u56fe\u6807")
    public String getPSSysImageId() {
        return this.strPSSysImageId;
    }

    protected void setPSSysImageId(String strPSSysImageId) {
        this.strPSSysImageId = strPSSysImageId;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u8fc7\u6ee4\u9879")
    public String getNavFilter() {
        return this.strNavFilter;
    }

    protected void setNavFilter(String strNavFilter) {
        this.strNavFilter = strNavFilter;
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6")
    public String getPSDEOPPrivId() {
        return this.strPSDEOPPrivId;
    }

    protected void setPSDEOPPrivId(String strPSDEOPPrivId) {
        this.strPSDEOPPrivId = strPSDEOPPrivId;
    }
}

