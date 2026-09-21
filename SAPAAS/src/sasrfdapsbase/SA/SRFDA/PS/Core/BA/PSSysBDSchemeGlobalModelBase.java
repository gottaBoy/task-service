/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSysBDSchemeGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSysBDScheme iPSSysBDScheme = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDScheme iPSSysBDScheme) {
        this.iPSSysBDScheme = iPSSysBDScheme;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSSysBDScheme getPSSysBDScheme() {
        return this.iPSSysBDScheme;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysBDScheme().getPSSysModelInstId();
    }
}

