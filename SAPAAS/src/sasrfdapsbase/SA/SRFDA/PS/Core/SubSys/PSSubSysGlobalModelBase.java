/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSubSysGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSubSys iPSSubSys = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSys iPSSubSys) {
        this.iPSSubSys = iPSSubSys;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSSubSys getPSSubSys() {
        return this.iPSSubSys;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSys().getPSSysModelInstId();
    }
}

