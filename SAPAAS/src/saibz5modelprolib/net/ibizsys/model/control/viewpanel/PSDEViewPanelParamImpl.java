/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.viewpanel.IPSDEViewPanelParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.viewpanel;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSControlParamImpl;
import net.ibizsys.model.control.viewpanel.IPSDEViewPanelParam;
import net.ibizsys.paas.util.StringHelper;

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
            if (StringHelper.isNullOrEmpty((String)this.getPSDEViewId())) {
                this.setPSDEViewId(iPSDEViewBarParam.getPSDEViewId());
            }
            if (StringHelper.isNullOrEmpty((String)this.getCaption())) {
                this.setCaption(iPSDEViewBarParam.getCaption());
            }
            if (StringHelper.isNullOrEmpty((String)this.getCapPSLanguageResId())) {
                this.setCapPSLanguageResId(iPSDEViewBarParam.getCapPSLanguageResId());
            }
        }
    }

    public String getCaption() {
        return this.strCaption;
    }

    protected void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getCapPSLanguageResId() {
        return this.strCapPSLanguageResId;
    }

    protected void setCapPSLanguageResId(String strCapPSLanguageResId) {
        this.strCapPSLanguageResId = strCapPSLanguageResId;
    }
}

