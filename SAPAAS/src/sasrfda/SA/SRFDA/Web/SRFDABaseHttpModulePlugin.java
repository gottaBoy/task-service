/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Web;

import SA.SRFDA.Web.ISRFDAHttpModulePlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class SRFDABaseHttpModulePlugin
implements ISRFDAHttpModulePlugin {
    @Override
    public CallResult Init(ISRFDAGlobalHelper iGlobalHelper) {
        return this.OnInit(iGlobalHelper);
    }

    protected CallResult OnInit(ISRFDAGlobalHelper iGlobalHelper) {
        return new CallResult();
    }
}

