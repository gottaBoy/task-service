/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Report
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  net.sf.jasperreports.engine.JRExporterParameter
 *  net.sf.jasperreports.engine.JasperPrint
 *  net.sf.jasperreports.engine.export.JRPdfExporter
 *  net.sf.jasperreports.engine.export.JRXhtmlExporter
 *  net.sf.jasperreports.engine.export.JRXlsExporter
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.Report;
import SA.SRFDA.Report.Web.ReportActionHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MPReportActionHelper
extends ReportActionHelper {
    private static final Log log = LogFactory.getLog(MPReportActionHelper.class);

    @Override
    public List<JasperPrint> GetReportPrint(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, Report report, BaseDataEntity dataEntity) {
        this.globalHelper = globalHelper;
        this.report = report;
        this.webContext = webContext;
        Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
        String strQueryModelId = report.getQUERYMODELID();
        if (StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
            dataEntities.add(dataEntity);
        } else {
            try {
                SelectResult selectResult = this.SelectReportData(dataEntity);
                int nRowCount = selectResult.getMainTable().GetRowCount();
                int i = 0;
                while (i < nRowCount) {
                    DataRow dr = selectResult.getMainTable().GetRow(i);
                    BaseDataEntity temp = new BaseDataEntity();
                    temp.FromDataRow(dr);
                    dataEntities.add(temp);
                    ++i;
                }
            }
            catch (Exception e) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u62a5\u8868\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
                return null;
            }
        }
        Vector reports = new Vector();
        CallResult callResult = globalHelper.getDAModelHelper().GetChildReports(report.getREPORTID(), reports);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868[%1$s]\u5b50\u62a5\u8868\uff0c%2$s", (Object)report.getREPORTID(), (Object)callResult.getErrorInfo()));
            return null;
        }
        ArrayList<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
        for (BaseDataEntity temp : dataEntities) {
            for (Report childReport : reports) {
                ReportActionHelper reportActionHelper = null;
                String strReportObject = childReport.getREPORTOBJECT();
                if (StringHelper.IsNullOrEmpty((String)strReportObject)) {
                    reportActionHelper = childReport.getMULTIPAGE() ? new MPReportActionHelper() : new ReportActionHelper();
                } else {
                    Object obj = ObjectHelper.Create((String)strReportObject);
                    if (obj == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u62a5\u8868\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strReportObject));
                        return null;
                    }
                    if (!(obj instanceof ReportActionHelper)) {
                        log.error((Object)StringHelper.Format((String)"\u62a5\u8868\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strReportObject));
                        return null;
                    }
                    reportActionHelper = (ReportActionHelper)obj;
                }
                List<JasperPrint> retList = ((ReportActionHelper)reportActionHelper).GetReportPrint(webContext, globalHelper, childReport, temp);
                if (retList == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u62a5\u8868[%1$s]\u6253\u5370\u8f93\u51fa\u5bf9\u8c61", (Object)childReport.getREPORTID()));
                    return null;
                }
                jasperPrintList.addAll(retList);
            }
        }
        return jasperPrintList;
    }

    @Override
    public String GetReportFile(ISRFDAWebContext webContext, ISRFDAGlobalHelper globalHelper, Report report, String strReportType) {
        this.globalHelper = globalHelper;
        this.report = report;
        this.webContext = webContext;
        this.strReportType = strReportType;
        Vector<Object> dataEntities = new Vector<Object>();
        String strQueryModelId = report.getQUERYMODELID();
        if (StringHelper.IsNullOrEmpty((String)strQueryModelId)) {
            dataEntities.add(new BaseDataEntity());
        } else {
            try {
                SelectResult selectResult = this.SelectReportData(null);
                int nRowCount = selectResult.getMainTable().GetRowCount();
                int i = 0;
                while (i < nRowCount) {
                    DataRow dataRow = selectResult.getMainTable().GetRow(i);
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.FromDataRow(dataRow);
                    dataEntities.add(dataEntity);
                    ++i;
                }
            }
            catch (Exception e) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u62a5\u8868\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
                return null;
            }
        }
        Vector reports = new Vector();
        CallResult callResult = globalHelper.getDAModelHelper().GetChildReports(report.getREPORTID(), reports);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868[%1$s]\u5b50\u62a5\u8868\uff0c%2$s", (Object)report.getREPORTID(), (Object)callResult.getErrorInfo()));
            return "";
        }
        ArrayList<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
        for (BaseDataEntity baseDataEntity : dataEntities) {
            for (Report childReport : reports) {
                ReportActionHelper reportActionHelper = null;
                String strReportObject = childReport.getREPORTOBJECT();
                if (StringHelper.IsNullOrEmpty((String)strReportObject)) {
                    reportActionHelper = childReport.getMULTIPAGE() ? new MPReportActionHelper() : new ReportActionHelper();
                } else {
                    Object obj = ObjectHelper.Create((String)strReportObject);
                    if (obj == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u62a5\u8868\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strReportObject));
                        return "";
                    }
                    if (!(obj instanceof ReportActionHelper)) {
                        log.error((Object)StringHelper.Format((String)"\u62a5\u8868\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strReportObject));
                        return "";
                    }
                    reportActionHelper = (ReportActionHelper)obj;
                }
                List<JasperPrint> retList = ((ReportActionHelper)reportActionHelper).GetReportPrint(webContext, globalHelper, childReport, baseDataEntity);
                if (retList == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u62a5\u8868[%1$s]\u6253\u5370\u8f93\u51fa\u5bf9\u8c61", (Object)childReport.getREPORTID()));
                    return "";
                }
                jasperPrintList.addAll(retList);
            }
        }
        String string = this.GetTmpFilePath();
        try {
            Object exporter = null;
            exporter = StringHelper.Compare((String)this.strReportType, (String)"PDF", (boolean)true) == 0 ? new JRPdfExporter() : (StringHelper.Compare((String)this.strReportType, (String)"EXCEL", (boolean)true) == 0 ? new JRXlsExporter() : (StringHelper.Compare((String)this.strReportType, (String)"HTML", (boolean)true) == 0 ? new JRXhtmlExporter() : new JRPdfExporter()));
            exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, (Object)string);
            exporter.exportReport();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5bfc\u51fa\u62a5\u8868\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return "";
        }
        return string;
    }
}

