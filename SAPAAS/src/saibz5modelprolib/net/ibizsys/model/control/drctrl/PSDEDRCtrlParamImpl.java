/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrlParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSMDAjaxControlParamImpl;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrlParam;
import net.ibizsys.paas.util.StringHelper;

public class PSDEDRCtrlParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEDRCtrlParam {
    private String strPSDEDRId = "";
    private String strPSSysCounterId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEDRId(this.psDEViewCtrl.getPSDEDRID());
        this.setPSSysCounterId(this.psDEViewCtrl.getPSSYSCOUNTERID());
    }

    public String getPSDEDRId() {
        return this.strPSDEDRId;
    }

    public void setPSDEDRId(String strPSDEDRId) {
        this.strPSDEDRId = strPSDEDRId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEDRCtrlParam) {
            IPSDEDRCtrlParam iPSDEDRCtrlParam = (IPSDEDRCtrlParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSDEDRId())) {
                this.setPSDEDRId(iPSDEDRCtrlParam.getPSDEDRId());
            }
            if (StringHelper.isNullOrEmpty((String)this.getPSSysCounterId())) {
                this.setPSSysCounterId(iPSDEDRCtrlParam.getPSSysCounterId());
            }
        }
    }

    public String getPSSysCounterId() {
        return this.strPSSysCounterId;
    }

    protected void setPSSysCounterId(String strPSSysCounterId) {
        this.strPSSysCounterId = strPSSysCounterId;
    }
}

