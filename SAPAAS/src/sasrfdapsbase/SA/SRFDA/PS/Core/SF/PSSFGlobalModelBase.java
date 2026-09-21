/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSFGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSF iPSSF = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSF iPSSF) {
        this.iPSSF = iPSSF;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSSF getPSSF() {
        return this.iPSSF;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSF().getPSSysModelInstId();
    }
}

