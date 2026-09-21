/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReportItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityObject;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEReport;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u62a5\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEReport")
public interface IPSAppDEReport
extends IPSDEReport,
IPSAppDataEntityObject {
    public void init(ISRFDAGlobalHelper var1, IPSAppDataEntity var2, PSDEReport var3) throws Exception;

    public IPSAppDEDataSet getPSAppDEDataSet();

    public IPSAppDEDataSet getPSAppDEDataSet2();

    public IPSAppDEDataSet getPSAppDEDataSet3();

    public IPSAppDEDataSet getPSAppDEDataSet4();

    public Iterator<IPSAppDEReportItem> getPSAppDEReportItems();

    public IPSAppBIScheme getPSAppBIScheme() throws Exception;

    public IPSAppBICube getPSAppBICube() throws Exception;

    public IPSAppBIReport getPSAppBIReport() throws Exception;

    public IPSLayoutPanel getPSLayoutPanel();
}

