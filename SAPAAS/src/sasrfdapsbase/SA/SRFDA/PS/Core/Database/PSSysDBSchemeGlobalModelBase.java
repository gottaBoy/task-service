/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

@PSModelIgnoreMeta
public abstract class PSSysDBSchemeGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSysDBScheme iPSSysDBScheme = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysDBScheme iPSSysDBScheme) {
        this.iPSSysDBScheme = iPSSysDBScheme;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSSysDBScheme getPSSysDBScheme() {
        return this.iPSSysDBScheme;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysDBScheme().getPSSysModelInstId();
    }
}

