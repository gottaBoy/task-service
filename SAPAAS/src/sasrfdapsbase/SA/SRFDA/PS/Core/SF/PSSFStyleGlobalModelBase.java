/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSFStyleGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSFStyle iPSSFStyle = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFStyle iPSSFStyle) {
        this.iPSSFStyle = iPSSFStyle;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSSFStyle getPSSFStyle() {
        return this.iPSSFStyle;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSFStyle().getPSSysModelInstId();
    }
}

