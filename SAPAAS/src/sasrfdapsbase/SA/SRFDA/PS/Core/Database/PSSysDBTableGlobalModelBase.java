/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

@PSModelIgnoreMeta
public abstract class PSSysDBTableGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSysDBTable iPSSysDBTable = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDBTable iPSSysDBTable) {
        this.iPSSysDBTable = iPSSysDBTable;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSSysDBTable getPSSysDBTable() {
        return this.iPSSysDBTable;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysDBTable().getPSSysModelInstId();
    }
}

