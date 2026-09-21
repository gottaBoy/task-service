/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewNavParam;
import SA.SRFDA.PS.Core.App.View.PSAppViewParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PSAppViewNavParamImpl
extends PSAppViewParamImpl
implements IPSAppViewNavParam {
    private boolean bRawValue = false;

    public void init(ISRFDAGlobalHelper iDGlobalHelper, IPSAppView iPSAppView, String strKey, String strValue, String strDesc, boolean bRawValue) throws Exception {
        super.init(iDGlobalHelper, iPSAppView, strKey, strValue, strDesc);
        this.bRawValue = bRawValue;
    }

    @Override
    public String getModelType() {
        return "PSAPPVIEWNAVPARAM";
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c")
    public boolean isRawValue() {
        return this.bRawValue;
    }
}

