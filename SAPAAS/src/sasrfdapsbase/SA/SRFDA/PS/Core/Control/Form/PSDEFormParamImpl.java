/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSSDAjaxControlParamImpl;
import SA.SRFramework.Utility.StringHelper;

public class PSDEFormParamImpl
extends PSSDAjaxControlParamImpl
implements IPSDEFormParam {
    private String strPSDEFormId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEFormId(this.psDEViewCtrl.getPSDEFORMID());
    }

    @Override
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
        if (iPSControlParam instanceof IPSDEFormParam && !StringHelper.IsNullOrEmpty((String)(iPSDEFormParam = (IPSDEFormParam)iPSControlParam).getPSDEFormId())) {
            this.setPSDEFormId(iPSDEFormParam.getPSDEFormId());
        }
    }
}

