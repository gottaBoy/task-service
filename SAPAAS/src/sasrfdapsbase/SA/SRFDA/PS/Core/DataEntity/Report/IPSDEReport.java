/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Report;

import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReportItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSDEReport;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u62a5\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEReport")
public interface IPSDEReport
extends IPSDataEntityObject {
    public static final String REPORTTYPE_JR = "JR";
    public static final String REPORTTYPE_LUCKYSHEET = "LUCKYSHEET";
    public static final String REPORTTYPE_SYSBICUBE = "SYSBICUBE";
    public static final String REPORTTYPE_DESYSBICUBES = "DESYSBICUBES";
    public static final String REPORTTYPE_ALLSYSBICUBES = "ALLSYSBICUBES";
    public static final String REPORTTYPE_SYSBIREPORT = "SYSBIREPORT";
    public static final String REPORTTYPE_DESYSBIREPORTS = "DESYSBIREPORTS";
    public static final String REPORTTYPE_SYSBICUBEREPORTS = "SYSBICUBEREPORTS";
    public static final String REPORTTYPE_ALLSYSBIREPORTS = "ALLSYSBIREPORTS";

    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEReport var3) throws Exception;

    public Iterator<IPSDEReportItem> getPSDEReportItems();

    public IPSDEDataSet getPSDEDataSet();

    public String getPSDEDataSetId();

    @Override
    public String getCodeName();

    public boolean isMultiPage();

    public boolean isEnableLog();

    public String getReportType();

    public String getReportFile();

    public IPSSysUniRes getPSSysUniRes();

    public IPSDEDataSet getPSDEDataSet2();

    public String getPSDEDataSetId2();

    public IPSDEDataSet getPSDEDataSet3();

    public String getPSDEDataSetId3();

    public IPSDEDataSet getPSDEDataSet4();

    public String getPSDEDataSetId4();

    @Override
    public int getExtendMode();

    public String getReportModel();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public int getPOTime();

    public String getSysUniResCode();

    public String getContentType();

    public String getReportTag();

    public String getReportTag2();

    public Properties getReportParams();

    public String getReportUIModel();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSSysBIScheme getPSSysBIScheme();

    public IPSSysBICube getPSSysBICube() throws Exception;

    public IPSSysBIReport getPSSysBIReport() throws Exception;

    public String getPSLayoutPanelId();
}

