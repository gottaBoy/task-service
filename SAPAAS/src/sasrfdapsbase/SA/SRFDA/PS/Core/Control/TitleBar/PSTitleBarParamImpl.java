/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.TitleBar;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBarParam;
import SA.SRFramework.Utility.StringHelper;

public class PSTitleBarParamImpl
extends PSControlParamImpl
implements IPSTitleBarParam {
    private String strPSTitleBarId = "";
    private String strTitleBarType = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSTitleBarId() {
        return this.strPSTitleBarId;
    }

    public void setPSTitleBarId(String strPSTitleBarId) {
        this.strPSTitleBarId = strPSTitleBarId;
    }

    @Override
    public String getTitleBarType() {
        return this.strTitleBarType;
    }

    public void setTitleBarType(String strTitleBarType) {
        this.strTitleBarType = strTitleBarType;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSTitleBarParam) {
            IPSTitleBarParam iPSTitleBarBarParam = (IPSTitleBarParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSTitleBarId())) {
                this.setPSTitleBarId(iPSTitleBarBarParam.getPSTitleBarId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getTitleBarType())) {
                this.setTitleBarType(iPSTitleBarBarParam.getTitleBarType());
            }
        }
    }
}

