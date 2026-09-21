/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.WF.Data.IDEWFDataCtrlPlugin;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;

public class SimpleWFDataCtrlPlugin
implements IDEWFDataCtrlPlugin {
    @Override
    public CallResult Execute(GlobalHelperEx globalHelperEx, BaseDataEntity dataEntity, String strOpPersonId) {
        return new CallResult();
    }
}

