/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Security;

import SA.SRFDA.Security.BaseDataAccHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;

public class UnlimitedDataAccHelper
extends BaseDataAccHelper {
    @Override
    public CallResult InternalTest(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, String strCurPersonId, BaseDataEntity dataEntity, String strAction) {
        return CallResult.Create((int)0);
    }
}

