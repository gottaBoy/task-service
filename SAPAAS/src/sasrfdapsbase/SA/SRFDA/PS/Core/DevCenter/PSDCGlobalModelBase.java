/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSDCGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSDevCenter iPSDevCenter = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDevCenter iPSDevCenter) {
        this.iPSDevCenter = iPSDevCenter;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSDevCenter getPSDevCenter() {
        return this.iPSDevCenter;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

