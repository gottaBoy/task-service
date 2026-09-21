/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.File
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAHttpServlet
 *  SA.SRFDA.Web.SRFDAHttpServletContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Ctrl.Data.File;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Data.NDFile;
import SA.SRFDA.ND.Data.NDFileHis;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAHttpServlet;
import SA.SRFDA.Web.SRFDAHttpServletContext;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
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

public class NDFilePreviewBuilder
extends SRFDAHttpServlet {
    private static final Log log = LogFactory.getLog(NDFilePreviewBuilder.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDEDataCtrl fileDataCtrl;
        this.addTimeOutHeaders(response);
        SRFDAHttpServletContext servletContext = new SRFDAHttpServletContext(request, response, this.getServletContext());
        String strFileId = servletContext.GetParamValue("NDFILEID");
        if (StringHelper.IsNullOrEmpty((String)strFileId)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u7f51\u76d8\u6587\u4ef6");
            return;
        }
        NDFile ndFile = new NDFile();
        ndFile.setNDFILEID(strFileId);
        IDEDataCtrl ndFileDataCtrl = servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("ND0013", (ISRFDAWebContext)servletContext);
        CallResult callResult = ndFileDataCtrl.Get((BaseDataEntity)ndFile);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u7f51\u76d8\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)strFileId, (Object)callResult.getErrorInfo()));
            return;
        }
        String strFileHisId = servletContext.GetParamValue("NDFILEHISID");
        NDFileHis ndFileHis = null;
        if (!StringHelper.IsNullOrEmpty((String)strFileHisId)) {
            ndFileHis = new NDFileHis();
            ndFileHis.setNDFILEHISID(strFileHisId);
            IDEDataCtrl ndFileHisDataCtrl = servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("ND0020", (ISRFDAWebContext)servletContext);
            callResult = ndFileHisDataCtrl.Get((BaseDataEntity)ndFileHis);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u7f51\u76d8\u6587\u4ef6\u5386\u53f2\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)strFileHisId, (Object)callResult.getErrorInfo()));
                return;
            }
            if (StringHelper.Compare((String)ndFile.getNDFILEID(), (String)ndFileHis.getNDFILEID(), (boolean)false) != 0) {
                log.error((Object)StringHelper.Format((String)"\u7f51\u76d8\u6587\u4ef6\u5386\u53f2\u53ca\u6587\u4ef6\u5bf9\u8c61\u4e0d\u4e00\u81f4"));
                return;
            }
        }
        File file = new File();
        file.setFILE_ID(ndFile.getFILEID());
        if (ndFileHis != null) {
            file.setFILE_ID(ndFileHis.getFILEID());
        }
        if ((callResult = (fileDataCtrl = servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0010", (ISRFDAWebContext)servletContext)).Get((BaseDataEntity)file)).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6[%1$s]\u6587\u4ef6\u5bf9\u8c61\u53d1\u751f\u9519\u8bef,%2$s", (Object)file.getFILE_ID(), (Object)callResult.getErrorInfo()));
            return;
        }
        String strFileLocalPath = servletContext.getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
        if (StringHelper.IsNullOrEmpty((String)strFileLocalPath)) {
            return;
        }
        String strReportFile = String.valueOf(strFileLocalPath) + file.getLOCALPATH();
        String strReportType = "";
        String[] parts = ndFile.getNDFILENAME().split("[.]");
        if (parts.length >= 2) {
            strReportType = parts[parts.length - 1];
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

