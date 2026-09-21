/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.form.IPSDEFormParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSSDAjaxControlParamImpl;
import net.ibizsys.model.control.form.IPSDEFormParam;
import net.ibizsys.paas.util.StringHelper;

public class PSDEFormParamImpl
extends PSSDAjaxControlParamImpl
implements IPSDEFormParam {
    private String strPSDEFormId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEFormId(this.psDEViewCtrl.getPSDEFORMID());
    }

    public String getPSDEFormId() {
        return this.strPSDEFormId;
    }

    public void setPSDEFormId(String strPSDEFormId) {
        this.strPSDEFormId = strPSDEFormId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSDEFormParam iPSDEFormParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEFormParam && !StringHelper.isNullOrEmpty((String)(iPSDEFormParam = (IPSDEFormParam)iPSControlParam).getPSDEFormId())) {
            this.setPSDEFormId(iPSDEFormParam.getPSDEFormId());
        }
    }
}

