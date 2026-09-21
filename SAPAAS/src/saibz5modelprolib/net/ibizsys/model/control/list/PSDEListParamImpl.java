/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.list.IPSDEListParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.list;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSMDAjaxControlParamImpl;
import net.ibizsys.model.control.list.IPSDEListParam;
import net.ibizsys.paas.util.StringHelper;

public class PSDEListParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEListParam {
    private String strPSDEListId = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEListId(this.psDEViewCtrl.getPSDELISTID());
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSDEListParam iPSDEListParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEListParam && !StringHelper.isNullOrEmpty((String)(iPSDEListParam = (IPSDEListParam)iPSControlParam).getPSDEListId())) {
            this.setPSDEListId(iPSDEListParam.getPSDEListId());
        }
    }

    public String getPSDEListId() {
        return this.strPSDEListId;
    }

    public void setPSDEListId(String strPSDEListId) {
        this.strPSDEListId = strPSDEListId;
    }
}

