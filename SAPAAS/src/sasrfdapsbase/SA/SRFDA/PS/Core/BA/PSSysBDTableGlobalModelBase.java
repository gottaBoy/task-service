/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSysBDTableGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSysBDTable iPSSysBDTable = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDTable iPSSysBDTable) {
        this.iPSSysBDTable = iPSSysBDTable;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSSysBDTable getPSSysBDTable() {
        return this.iPSSysBDTable;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysBDTable().getPSSysModelInstId();
    }
}

