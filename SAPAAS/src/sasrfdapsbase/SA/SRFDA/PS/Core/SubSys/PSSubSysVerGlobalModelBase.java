/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSubSysVerGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSubSysVer iPSSubSysVer = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysVer iPSSubSysVer) {
        this.iPSSubSysVer = iPSSubSysVer;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSSubSysVer getPSSubSysVer() {
        return this.iPSSubSysVer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysVer().getPSSysModelInstId();
    }

    @Override
    protected boolean isAlwaysActivePSSysModelInst() {
        return true;
    }
}

