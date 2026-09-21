/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepFI;
import SA.SRFDA.BI.Ctrl.Data.BIRepFIType;
import SA.SRFDA.BI.Ctrl.IBIRepFIHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFilterHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepFITypeHelper {
    public void Init(ISRFDAGlobalHelper var1, BIRepFIType var2) throws Exception;

    public IBIRepFIHelper GetBIRepFI(IBIRepFilterHelper var1, BIRepFI var2) throws Exception;

    public String getCtrlNameSpace();

    public String getCtrlObject();
}

