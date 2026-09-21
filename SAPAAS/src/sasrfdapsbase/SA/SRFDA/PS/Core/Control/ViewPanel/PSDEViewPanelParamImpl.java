/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanelParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEViewPanelParamImpl
extends PSControlParamImpl
implements IPSDEViewPanelParam {
    private String strPSDEViewId = "";
    private String strCaption = "";
    private String strCapPSLanguageResId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEViewId(this.psDEViewCtrl.getPSDEVIEWID());
        this.setCaption(this.psDEViewCtrl.getCAPTION());
        this.strCapPSLanguageResId = this.psDEViewCtrl.getCAPPSLANRESID();
    }

    @Override
    public String getPSDEViewId() {
        return this.strPSDEViewId;
    }

    public void setPSDEViewId(String strPSDEViewId) {
        this.strPSDEViewId = strPSDEViewId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEViewPanelParam) {
            IPSDEViewPanelParam iPSDEViewBarParam = (IPSDEViewPanelParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEViewId())) {
                this.setPSDEViewId(iPSDEViewBarParam.getPSDEViewId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getCaption())) {
                this.setCaption(iPSDEViewBarParam.getCaption());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getCapPSLanguageResId())) {
                this.setCapPSLanguageResId(iPSDEViewBarParam.getCapPSLanguageResId());
            }
        }
    }

    @Override
    public String getCaption() {
        return this.strCaption;
    }

    protected void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    @Override
    public String getCapPSLanguageResId() {
        return this.strCapPSLanguageResId;
    }

    protected void setCapPSLanguageResId(String strCapPSLanguageResId) {
        this.strCapPSLanguageResId = strCapPSLanguageResId;
    }
}

