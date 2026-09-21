/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Report
 *  SA.SRFDA.Security.UniResHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFDA.Web.SRFDAHttpServletContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.SRFExHttpServletContext
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.Report;
import SA.SRFDA.Report.Web.MPReportActionHelper;
import SA.SRFDA.Report.Web.ReportActionHelper;
import SA.SRFDA.Security.UniResHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.SRFExHttpServletContext;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReportBuilder
extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(ReportBuilder.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(request, response, this.getServletContext());
        String strReportId = servletContext.GetParamValue("REPORTID");
        if (StringHelper.IsNullOrEmpty((String)strReportId)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u62a5\u8868\u7f16\u53f7");
            return;
        }
        if (!servletContext.GetUserPrivilegeMgr().Test((SRFExHttpServletContext)servletContext, UniResHelper.GetReportResId((String)strReportId))) {
            log.error((Object)StringHelper.Format((String)"\u7528\u6237\u6ca1\u6709\u8bbf\u95ee\u6307\u5b9a\u62a5\u8868[%1$s]\u7684\u80fd\u529b", (Object)strReportId));
            return;
        }
        Report report = new Report();
        CallResult callResult = servletContext.getGlobalHelper().getDAModelHelper().GetReport(strReportId, report);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868[%1$s]\uff0c%2$s", (Object)strReportId, (Object)callResult.getErrorInfo()));
            return;
        }
        ReportActionHelper reportActionHelper = null;
        String strReportObject = report.getREPORTOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strReportObject)) {
            reportActionHelper = report.getMULTIPAGE() ? new MPReportActionHelper() : new ReportActionHelper();
        } else {
            Object obj = ObjectHelper.Create((String)strReportObject);
            if (obj == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u62a5\u8868\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)strReportObject));
                return;
            }
            if (!(obj instanceof ReportActionHelper)) {
                log.error((Object)StringHelper.Format((String)"\u62a5\u8868\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strReportObject));
                return;
            }
            reportActionHelper = (ReportActionHelper)obj;
        }
        String strReportType = this.getInitParameter("REPORTTYPE");
        String strReportFile = reportActionHelper.GetReportFile((ISRFDAWebContext)servletContext, (ISRFDAGlobalHelper)servletContext.getGlobalHelper(), report, strReportType);
        if (StringHelper.IsNullOrEmpty((String)strReportFile)) {
            log.error((Object)StringHelper.Format((String)"\u751f\u6210\u62a5\u8868\u6587\u4ef6\u5931\u8d25"));
            return;
        }
        if (StringHelper.Compare((String)strReportType, (String)"PDF", (boolean)true) == 0) {
            response.setContentType("application/pdf");
        }
        if (StringHelper.Compare((String)strReportType, (String)"HTML", (boolean)true) == 0) {
            response.setContentType("text/html");
        }
        if (StringHelper.Compare((String)strReportType, (String)"EXCEL", (boolean)true) == 0) {
            response.setContentType("application/vnd.ms-excel");
        }
        if (StringHelper.Compare((String)strReportType, (String)"HTML", (boolean)true) == 0) {
            String strFileName = strReportFile.replace(servletContext.getGlobalHelper().GetTempPath(), "");
            strFileName = String.valueOf(strFileName) + "_files/";
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(strReportFile), "UTF-8"));
                String line = reader.readLine();
                while (line != null) {
                    String strHtml = line.replace(strFileName, "");
                    strHtml = strHtml.replace("10.0px;", "15.0px;");
                    response.getOutputStream().write(strHtml.getBytes("UTF-8"));
                    line = reader.readLine();
                }
                reader.close();
            }
            catch (IOException e) {
                e.getStackTrace();
            }
        } else {
            BufferedInputStream bis = null;
            FilterOutputStream bos = null;
            try {
                try {
                    int bytesRead;
                    bis = new BufferedInputStream(new FileInputStream(strReportFile));
                    bos = new BufferedOutputStream((OutputStream)response.getOutputStream());
                    byte[] buff = new byte[2048];
                    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                        ((BufferedOutputStream)bos).write(buff, 0, bytesRead);
                    }
                }
                catch (IOException e) {
                    System.out.println("\u51fa\u73b0IOException." + e);
                    if (bis != null) {
                        bis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                }
            }
            finally {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            }
        }
    }
}

