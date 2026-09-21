/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAModelHelper;
import SA.SRFramework.Utility.StringHelper;

public class DB2DAModelHelper
extends BaseDAModelHelper {
    @Override
    protected String GetSQL_GetDefaultDEDataGrid(String strDataEntityId) {
        return StringHelper.Format((String)"select * from t_SRFDATAGrid where  ISMAJOR = 1 and  DEID='%1$s' fetch first 1 row only", (Object)strDataEntityId);
    }
}

