/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.viewpanel.IPSDETabViewPanelParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.viewpanel;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.viewpanel.IPSDETabViewPanelParam;
import net.ibizsys.model.control.viewpanel.PSDEViewPanelParamImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSDETabViewPanelParamImpl
extends PSDEViewPanelParamImpl
implements IPSDETabViewPanelParam {
    private String strPSSysCounterId = "";
    private String strCounterId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysCounterId(this.psDEViewCtrl.getPSSYSCOUNTERID());
        this.setCounterId(this.psDEViewCtrl.getCTRLPARAM3());
    }

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
            if (StringHelper.isNullOrEmpty((String)this.getPSSysCounterId())) {
                this.setPSSysCounterId(iPSDETabViewPanelParam.getPSSysCounterId());
            }
            if (StringHelper.isNullOrEmpty((String)this.getCounterId())) {
                this.setCounterId(iPSDETabViewPanelParam.getCounterId());
            }
        }
    }

    public String getCounterId() {
        return this.strCounterId;
    }

    protected void setCounterId(String strCounterId) {
        this.strCounterId = strCounterId;
    }
}

