/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSAppDEFieldGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSAppDEField iPSAppDEField = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDEField iPSAppDEField) {
        this.iPSAppDEField = iPSAppDEField;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    protected IPSDEField getPSDEField() {
        return this.getPSAppDEField().getPSDEField();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppDEField().getPSSysModelInstId();
    }
}

