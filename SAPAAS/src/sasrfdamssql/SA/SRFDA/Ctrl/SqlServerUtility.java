/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.IDBModelHelper
 *  SA.SRFDA.Web.Utility.GlobalHelperEx
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;

public class SqlServerUtility {
    public static IDBModelHelper GetDBModelHelper(DataEntity dataEntity, GlobalHelperEx globalHelperEx) {
        String strDBModelHelper = globalHelperEx.getWebExConfig().GetValue("SRFDA", "DBMODELHELPER", "");
        Object obj = ObjectHelper.Create((String)strDBModelHelper);
        if (obj == null || !(obj instanceof IDBModelHelper)) {
            return null;
        }
        IDBModelHelper iDBModelHelper = (IDBModelHelper)obj;
        iDBModelHelper.Init(dataEntity, (ISRFDAGlobalHelper)globalHelperEx);
        return iDBModelHelper;
    }
}

