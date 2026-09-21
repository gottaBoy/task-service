/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IDAGlobalModel<KT, VT, HT> {
    public CallResult Init(ISRFDAGlobalHelper var1);

    public VT FindModel(KT var1);

    public HT FindModelHelper(KT var1) throws Exception;

    public void ResetModel(KT var1);

    public void ResetAll();
}

