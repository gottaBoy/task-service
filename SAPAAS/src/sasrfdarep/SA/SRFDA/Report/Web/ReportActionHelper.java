/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.Data.Report
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ISRFExWebContext
 *  net.sf.jasperreports.engine.JRDataSource
 *  net.sf.jasperreports.engine.JRException
 *  net.sf.jasperreports.engine.JRExporterParameter
 *  net.sf.jasperreports.engine.JasperFillManager
 *  net.sf.jasperreports.engine.JasperPrint
 *  net.sf.jasperreports.engine.JasperRunManager
 *  net.sf.jasperreports.engine.export.JExcelApiExporter
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.Data.Report;
import SA.SRFDA.Report.DAJRDataSource;
import SA.SRFDA.Report.Web.DefaultReportContext;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ISRFExWebContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReportActionHelper {
    protected ISRFDAGlobalHelper globalHelper = null;
    protected Report report = null;
    protected ISRFDAWebContext webContext = null;
    protected String strReportType = "";
    private static final Log log = LogFactory.getLog(ReportActionHelper.class);

    public List<JasperPrint> GetReportPrint(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, Report report, BaseDataEntity dataEntity) {
        SelectResult selectResult;
        this.globalHelper = globalHelper;
        this.report = report;
        this.webContext = webContext;
        try {
            selectResult = this.SelectReportData(dataEntity);
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u62a5\u8868\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            return null;
        }
        TreeMap<String, DefaultReportContext> parameters = new TreeMap<String, DefaultReportContext>();
        parameters.put("SRFRC", this.CreateReportContext(dataEntity));
        this.FillParameters(parameters);
        String strReportFullPath = String.valueOf(globalHelper.GetAppRootPath()) + "srfreport" + File.separator + "report" + File.separator + report.getREPORTPATH().replace("/", File.separator);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport((String)strReportFullPath, parameters, (JRDataSource)this.GetJRDataSource(selectResult.getMainTable()));
            if (jasperPrint != null) {
                ArrayList<JasperPrint> list = new ArrayList<JasperPrint>();
                list.add(jasperPrint);
                return list;
            }
            return null;
        }
        catch (JRException e) {
            log.error((Object)StringHelper.Format((String)"\u586b\u5145\u62a5\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            return null;
        }
    }

    public String GetReportFile(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, Report report, String strReportType) {
        SelectResult selectResult;
        this.globalHelper = globalHelper;
        this.report = report;
        this.webContext = webContext;
        this.strReportType = strReportType;
        try {
            selectResult = this.SelectReportData(null);
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u62a5\u8868\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            return "";
        }
        String strReportFullPath = String.valueOf(globalHelper.GetAppRootPath()) + "srfreport" + File.separator + "report" + File.separator + report.getREPORTPATH().replace("/", File.separator);
        String strTempFilePath = this.GetTmpFilePath();
        TreeMap<String, DefaultReportContext> parameters = new TreeMap<String, DefaultReportContext>();
        parameters.put("SRFRC", this.CreateReportContext(null));
        this.FillParameters(parameters);
        if (this.ExportReportFile(strReportFullPath, strTempFilePath, parameters, selectResult)) {
            return strTempFilePath;
        }
        return "";
    }

    protected DefaultReportContext CreateReportContext(BaseDataEntity dataEntity) {
        DefaultReportContext defaultReportContext = new DefaultReportContext();
        defaultReportContext.setWebContext(this.webContext);
        defaultReportContext.setGlobalHelper(this.globalHelper);
        defaultReportContext.setDataEntity(dataEntity);
        return defaultReportContext;
    }

    protected void FillParameters(Map parameters) {
    }

    protected SelectResult CallSelect(String strSQL, Vector<CallParam> params) {
        return this.CallSelect("", strSQL, params);
    }

    protected SelectResult SelectReportData(BaseDataEntity dataEntity) throws Exception {
        String strQueryModelId = this.report.getQUERYMODELID();
        BaseDAQueryModelHelper queryModelHelper = this.globalHelper.getDAModelStorage().FindDAQueryModelHelper(strQueryModelId);
        if (queryModelHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u68c0\u7d22\u6a21\u578b[%1$s]", (Object)strQueryModelId));
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u68c0\u7d22\u6a21\u578b[%1$s]", (Object)strQueryModelId));
        }
        Vector userConditions = new Vector();
        queryModelHelper.FillMajorConditions(userConditions);
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.GetDAModelQueryScript(queryModelHelper));
        if (userConditions.size() != 0) {
            script.Append(" WHERE ");
            boolean bFirst = true;
            for (String strCondition : userConditions) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    script.Append(" AND ");
                }
                script.Append("(%1$s)", (Object)strCondition);
            }
        }
        Vector<CallParam> params = new Vector<CallParam>();
        queryModelHelper.FillQMDeclareParams(params, this.webContext, this.globalHelper, "", dataEntity);
        String strSQL = script.toString();
        if (this.report.isENABLEGROUP()) {
            strSQL = queryModelHelper.GetGroupSQL(strSQL, this.report.getQueryGroupModelConfig(), params, this.webContext, this.globalHelper, "", null);
        }
        queryModelHelper.FillCallParams(params, this.webContext, this.globalHelper, "", dataEntity);
        strSQL = String.valueOf(queryModelHelper.GetQMDeclareScript()) + strSQL;
        strSQL = queryModelHelper.ReplaceURLParamMacro(strSQL, (ISRFExWebContext)this.webContext);
        SelectResult selectResult = this.CallSelect(queryModelHelper.GetMajorDEHelper().GetDBStorage(), strSQL, params);
        if (selectResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8bed\u53e5\u53d1\u751f\u9519\u8bef[%1$s],%2$s", (Object)strSQL, (Object)selectResult.getErrorInfo()));
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u8bed\u53e5\u53d1\u751f\u9519\u8bef[%1$s],%2$s", (Object)strSQL, (Object)selectResult.getErrorInfo()));
        }
        return selectResult;
    }

    protected SelectResult CallSelect(String strDBStorage, String strSQL, Vector<CallParam> params) {
        try {
            StringBuilderEx info = new StringBuilderEx();
            info.Append("REPORT SQL\r\rn%1$s\r\n", (Object)strSQL);
            if (params != null) {
                int i = 0;
                while (i < params.size()) {
                    CallParam callParam = params.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
            }
            log.info((Object)info.toString());
            SelectResult selectResult = this.globalHelper.getDBCaller(strDBStorage).CallRaw3(strSQL, params);
            if (selectResult == null) {
                selectResult = new SelectResult();
                selectResult.setRetCode(1);
                selectResult.setErrorInfo("\u5185\u90e8\u53d1\u751f\u9519\u8bef");
                return selectResult;
            }
            return selectResult;
        }
        catch (Exception ex) {
            SelectResult selectResult = new SelectResult();
            selectResult.setRetCode(1);
            selectResult.setErrorInfo("\u5185\u90e8\u53d1\u751f\u9519\u8bef");
            return selectResult;
        }
    }

    protected JRDataSource GetJRDataSource(DataTable dataTable) {
        DAJRDataSource jrDataSource = new DAJRDataSource(dataTable);
        int nColumnCount = Integer.parseInt(this.report.GetReportProperty("DSCOLUMNCOUNT", "-1"));
        int nMaxRowCount = Integer.parseInt(this.report.GetReportProperty("DSMAXROWCOUNT", "-1"));
        if (nColumnCount != -1) {
            jrDataSource.setColumnCount(nColumnCount);
        }
        if (nMaxRowCount != -1) {
            jrDataSource.setMaxRowCount(nMaxRowCount);
        }
        return jrDataSource;
    }

    protected boolean ExportReportFile(String strReportPath, String strTempPath, Map parameters, SelectResult selectResult) {
        if (StringHelper.Compare((String)this.strReportType, (String)"PDF", (boolean)true) == 0) {
            try {
                JasperRunManager.runReportToPdfFile((String)strReportPath, (String)strTempPath, (Map)parameters, (JRDataSource)this.GetJRDataSource(selectResult.getMainTable()));
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (StringHelper.Compare((String)this.strReportType, (String)"HTML", (boolean)true) == 0) {
            try {
                JasperRunManager.runReportToHtmlFile((String)strReportPath, (String)strTempPath, (Map)parameters, (JRDataSource)this.GetJRDataSource(selectResult.getMainTable()));
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (StringHelper.Compare((String)this.strReportType, (String)"EXCEL", (boolean)true) == 0) {
            JasperPrint report = null;
            try {
                report = JasperFillManager.fillReport((String)strReportPath, (Map)parameters, (JRDataSource)this.GetJRDataSource(selectResult.getMainTable()));
                JExcelApiExporter exporter = new JExcelApiExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, (Object)report);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, (Object)new File(strTempPath));
                exporter.exportReport();
                return true;
            }
            catch (JRException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected String GetTmpFilePath() {
        if (StringHelper.Compare((String)this.strReportType, (String)"PDF", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s%2$s.pdf", (Object)this.globalHelper.GetTempPath(), (Object)Helper.GenGuid());
        }
        if (StringHelper.Compare((String)this.strReportType, (String)"EXCEL", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s%2$s.xls", (Object)this.globalHelper.GetTempPath(), (Object)Helper.GenGuid());
        }
        if (StringHelper.Compare((String)this.strReportType, (String)"HTML", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s%2$s.html", (Object)this.globalHelper.GetTempPath(), (Object)Helper.GenGuid());
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)this.globalHelper.GetTempPath(), (Object)Helper.GenGuid());
    }
}

