/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.Data.PrintForm
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
import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Report.DAJRDataSource;
import SA.SRFDA.Report.DataEntityJRDataSource;
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

public class PrintFormActionHelper {
    protected ISRFDAGlobalHelper globalHelper = null;
    protected PrintForm PrintForm = null;
    protected ISRFDAWebContext webContext = null;
    protected String strPrintFormType = "";
    private static final Log log = LogFactory.getLog(PrintFormActionHelper.class);

    public String GetPrintFormFile(BaseDataEntity dataEntity, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, PrintForm PrintForm2, String strPrintFormType) {
        this.globalHelper = globalHelper;
        this.PrintForm = PrintForm2;
        this.webContext = webContext;
        this.strPrintFormType = strPrintFormType;
        SelectResult selectResult = null;
        String strQueryModelId = PrintForm2.getQUERYMODELID();
        if (!StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
            BaseDAQueryModelHelper queryModelHelper = this.globalHelper.getDAModelStorage().FindDAQueryModelHelper(strQueryModelId);
            if (queryModelHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u68c0\u7d22\u6a21\u578b[%1$s]", (Object)strQueryModelId));
                return "";
            }
            Vector<String> userConditions = new Vector<String>();
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
            queryModelHelper.FillQMDeclareParams(params, this.webContext, globalHelper, "", dataEntity);
            String strSQL = script.toString();
            if (PrintForm2.isENABLEGROUP()) {
                strSQL = queryModelHelper.GetGroupSQL(strSQL, PrintForm2.getQueryGroupModelConfig(), params, this.webContext, globalHelper, "", dataEntity);
                log.info((Object)("GROUP SQL:\r\n" + strSQL));
            }
            queryModelHelper.FillCallParams(params, this.webContext, globalHelper, "", dataEntity);
            strSQL = String.valueOf(queryModelHelper.GetQMDeclareScript()) + strSQL;
            strSQL = queryModelHelper.ReplaceURLParamMacro(strSQL, (ISRFExWebContext)this.webContext);
            selectResult = this.CallSelect(queryModelHelper.GetMajorDEHelper().GetDBStorage(), strSQL, params);
            if (selectResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u8bed\u53e5\u53d1\u751f\u9519\u8bef[%1$s],%2$s", (Object)strSQL, (Object)selectResult.getErrorInfo()));
                return "";
            }
        }
        String strPrintFormPath = String.valueOf(globalHelper.GetAppRootPath()) + "srfreport" + File.separator + "printform" + File.separator + PrintForm2.getREPORTPATH().replace("/", File.separator);
        String strTempFilePath = this.GetTmpFilePath();
        TreeMap<String, DefaultReportContext> parameters = new TreeMap<String, DefaultReportContext>();
        DefaultReportContext defaultReportContext = new DefaultReportContext();
        defaultReportContext.setWebContext(webContext);
        defaultReportContext.setGlobalHelper(globalHelper);
        defaultReportContext.setDataEntity(dataEntity);
        parameters.put("SRFRC", defaultReportContext);
        this.FillParameters(parameters);
        if (this.ExportPrintFormFile(strPrintFormPath, strTempFilePath, parameters, selectResult)) {
            return strTempFilePath;
        }
        return "";
    }

    public String GetPrintFormFile(Vector<BaseDataEntity> dataEntities, ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, PrintForm PrintForm2, String strPrintFormType) {
        this.globalHelper = globalHelper;
        this.PrintForm = PrintForm2;
        this.webContext = webContext;
        this.strPrintFormType = strPrintFormType;
        String strPrintFormPath = String.valueOf(globalHelper.GetAppRootPath()) + "srfreport" + File.separator + "printform" + File.separator + PrintForm2.getREPORTPATH().replace("/", File.separator);
        String strTempFilePath = this.GetTmpFilePath();
        TreeMap<String, DefaultReportContext> parameters = new TreeMap<String, DefaultReportContext>();
        DefaultReportContext defaultReportContext = new DefaultReportContext();
        defaultReportContext.setWebContext(webContext);
        defaultReportContext.setGlobalHelper(globalHelper);
        parameters.put("SRFRC", defaultReportContext);
        this.FillParameters(parameters);
        if (this.ExportPrintFormFile(strPrintFormPath, strTempFilePath, parameters, dataEntities)) {
            return strTempFilePath;
        }
        return "";
    }

    protected void FillParameters(Map parameters) {
    }

    protected SelectResult CallSelect(String strSQL, Vector<CallParam> params) {
        return this.CallSelect("", strSQL, params);
    }

    protected SelectResult CallSelect(String strDBStorage, String strSQL, Vector<CallParam> params) {
        try {
            SelectResult selectResult;
            if (params != null) {
                StringBuilderEx info = new StringBuilderEx();
                int i = 0;
                while (i < params.size()) {
                    CallParam callParam = params.get(i);
                    info.Append("\u53c2\u6570[%1$s][%2$s][%3$s]\r\n", (Object)(i + 1), (Object)callParam.getParamName(), callParam.getValue());
                    ++i;
                }
                log.info((Object)info.toString());
            }
            if ((selectResult = this.globalHelper.getDBCaller(strDBStorage).CallRaw3(strSQL, params)) == null) {
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

    protected boolean ExportPrintFormFile(String strPrintFormPath, String strTempPath, Map parameters, SelectResult selectResult) {
        if (StringHelper.Compare((String)this.strPrintFormType, (String)"PDF", (boolean)true) == 0) {
            try {
                JasperRunManager.runReportToPdfFile((String)strPrintFormPath, (String)strTempPath, (Map)parameters, (JRDataSource)this.GetJRDataSource(selectResult == null ? null : selectResult.getMainTable()));
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (StringHelper.Compare((String)this.strPrintFormType, (String)"EXCEL", (boolean)true) == 0) {
            JasperPrint report = null;
            try {
                report = JasperFillManager.fillReport((String)strPrintFormPath, (Map)parameters, (JRDataSource)this.GetJRDataSource(selectResult.getMainTable()));
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

    protected boolean ExportPrintFormFile(String strPrintFormPath, String strTempPath, Map parameters, Vector<BaseDataEntity> dataEntities) {
        if (StringHelper.Compare((String)this.strPrintFormType, (String)"PDF", (boolean)true) == 0) {
            try {
                JasperRunManager.runReportToPdfFile((String)strPrintFormPath, (String)strTempPath, (Map)parameters, (JRDataSource)this.GetJRDataSource(dataEntities == null ? null : dataEntities));
                return true;
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    protected JRDataSource GetJRDataSource(DataTable dataTable) {
        return new DAJRDataSource(dataTable);
    }

    protected JRDataSource GetJRDataSource(Vector<BaseDataEntity> dataEntities) {
        return new DataEntityJRDataSource(dataEntities);
    }

    protected String GetDAModelQueryScript(BaseDAQueryModelHelper daQueryModelHelper) {
        return daQueryModelHelper.GetQueryModelScript();
    }

    protected String GetTmpFilePath() {
        if (StringHelper.Compare((String)this.strPrintFormType, (String)"PDF", (boolean)true) == 0) {
            return StringHelper.Format((String)"%1$s%2$s.pdf", (Object)this.globalHelper.GetTempPath(), (Object)Helper.GenGuid());
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)this.globalHelper.GetTempPath(), (Object)Helper.GenGuid());
    }
}

