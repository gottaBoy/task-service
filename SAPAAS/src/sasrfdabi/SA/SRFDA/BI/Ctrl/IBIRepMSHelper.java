/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIRepMS;
import SA.SRFDA.BI.Ctrl.IBICubeMeasureHelper;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IBIRepMSHelper {
    public void Init(ISRFDAGlobalHelper var1, IBIReportExHelper var2, BIRepMS var3) throws Exception;

    public IBICubeMeasureHelper getBICubeMeasure();

    public int getPlacePos();

    public int getColumnWidth();

    public String getGroupName();

    public String getLogicName();
}

