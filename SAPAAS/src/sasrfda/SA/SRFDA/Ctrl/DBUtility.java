/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBUtility {
    private static final Log log = LogFactory.getLog(DBUtility.class);

    public static IDBModelHelper GetDBModelHelper(DataEntity dataEntity, ISRFDAGlobalHelper globalHelperEx) {
        String strDBModelHelper = "";
        if (StringHelper.IsNullOrEmpty((String)dataEntity.getDBSTORAGE())) {
            strDBModelHelper = globalHelperEx.getWebExConfig().GetValue("SRFDA", "DBMODELHELPER", "");
        } else {
            IDBStorage iDBStorage = globalHelperEx.getDAModelStorage().FindDBStorage(dataEntity.getDBSTORAGE());
            if (iDBStorage == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5e93\u5b58\u50a8[%1$s]\u5bf9\u8c61", (Object)dataEntity.getDBSTORAGE()));
                return null;
            }
            strDBModelHelper = iDBStorage.GetProperty("DBMODELHELPER");
        }
        Object obj = ObjectHelper.Create((String)strDBModelHelper);
        if (obj == null || !(obj instanceof IDBModelHelper)) {
            return null;
        }
        IDBModelHelper iDBModelHelper = (IDBModelHelper)obj;
        iDBModelHelper.Init(dataEntity, globalHelperEx);
        return iDBModelHelper;
    }
}

