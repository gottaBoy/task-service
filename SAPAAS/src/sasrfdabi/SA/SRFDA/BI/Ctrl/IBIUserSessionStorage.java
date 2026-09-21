/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.IBICubeCache;
import SA.SRFDA.BI.Ctrl.IBICubeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIUserSessionStorage {
    public void Init(ISRFDAGlobalHelper var1, String var2) throws Exception;

    public IBICubeCache GetBICubeCache(IBICubeHelper var1, String var2, String var3) throws Exception;
}

