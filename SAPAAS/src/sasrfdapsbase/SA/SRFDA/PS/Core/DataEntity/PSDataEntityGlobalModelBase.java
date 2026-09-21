/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSDataEntityGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSDataEntity iPSDataEntity = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDataEntity().getPSSysModelInstId();
    }
}

