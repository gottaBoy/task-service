/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSDEFieldGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSDEField iPSDEField = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEField iPSDEField) {
        this.iPSDEField = iPSDEField;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEField().getPSSysModelInstId();
    }
}

