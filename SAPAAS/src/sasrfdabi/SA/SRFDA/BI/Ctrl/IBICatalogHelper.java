/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BICatalog;
import SA.SRFDA.BI.Ctrl.IBIDimensionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBICatalogHelper {
    public void Init(ISRFDAGlobalHelper var1, BICatalog var2) throws Exception;

    public String getId();

    public String getName();

    public int getVersion();

    public IBIDimensionHelper FindBIDimension(String var1) throws Exception;
}

