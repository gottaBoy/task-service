/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.Data.BIReport;
import SA.SRFDA.BI.Ctrl.IBIReportExHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDABIConfigHelper {
    public boolean Init(ISRFDAGlobalHelper var1, String var2, String var3);

    public ISRFDAGlobalHelper getGlobalHelper();

    public String getLanguage();

    public String getPageModel();

    public String GetBIReportSPExConfigId(BIReport var1);

    public String GetBIReportExSPExConfigId(IBIReportExHelper var1) throws Exception;
}

