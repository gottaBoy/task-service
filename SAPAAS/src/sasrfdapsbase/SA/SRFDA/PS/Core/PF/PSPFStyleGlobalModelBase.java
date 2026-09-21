/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSPFStyleGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSPFStyle iPSPFStyle = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPFStyle iPSPFStyle) {
        this.iPSPFStyle = iPSPFStyle;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPFStyle().getPSSysModelInstId();
    }

    protected IPSPF getPSPF() {
        return this.getPSPFStyle().getPSPF();
    }
}

