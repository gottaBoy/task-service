/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepPL;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepPLHelper {
    public void Init(ISRFDAGlobalHelper var1, BIRepPL var2) throws Exception;

    public BIRepPL getBIRepPL();

    public String getNamespace();

    public String getCtrlName();
}

