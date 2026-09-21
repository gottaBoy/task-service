/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepRP;
import SA.SRFDA.BI.Ctrl.IBIRepPanelHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepRPHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIReportExHelper var2, BIRepRP var3) throws Exception;

    public String getCaption();

    public IBIRepPanelHelper getBIRepPanel();
}

