/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPSetting;
import SA.SRFDA.EAI.Data.DBOPPKG;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDBOPPKG {
    public void Init(DBOPPKG var1, IDBOPSetting var2, ISRFDAGlobalHelper var3) throws Exception;

    public void Publish(boolean var1) throws Exception;

    public String getProcName();
}

