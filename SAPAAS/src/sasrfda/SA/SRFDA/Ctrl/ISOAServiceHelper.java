/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.SOAService;
import SA.SRFDA.Ctrl.SOAResult;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface ISOAServiceHelper {
    public void Init(ISRFDAGlobalHelper var1, SOAService var2) throws Exception;

    public int getVersion();

    public boolean getValidFlag();

    public SOAResult Call(String var1, String var2) throws Exception;
}

