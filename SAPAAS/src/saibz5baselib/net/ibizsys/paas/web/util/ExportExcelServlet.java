/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package net.ibizsys.paas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DEDataImportTemplateHelper;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.ExportFilePage;

public class ExportExcelServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        try {
            SessionFactoryManager.enter();
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent(iWebContext);
            this.onProcessAction();
            this.resetCurrent();
            return;
        }
        catch (Exception ex) {
            this.resetCurrent();
            return;
        }
    }

    @Override
    protected AjaxActionResult onProcessAction() throws Exception {
        String strDEId;
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        String strFileName = this.getWebContext().getParamValue("FILEID");
        if (StringHelper.isNullOrEmpty(strFileName) && !StringHelper.isNullOrEmpty(strDEId = WebContext.getDEId(this.getWebContext()))) {
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strDEId);
            String strDEDataImport = WebContext.getDEDataImport(this.getWebContext());
            String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());
            String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");
            DEDataImportTemplateHelper.output(iDataEntityModel, strTempFilePath);
            strFileName = strTempFileName;
        }
        if (StringHelper.isNullOrEmpty(strFileName)) {
            ajaxActionResult.setRetCode(5);
            ajaxActionResult.setErrorInfo(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u6587\u4ef6\u4fe1\u606f"));
            return ajaxActionResult;
        }
        String strExportType = this.getWebContext().getParamValue("EXPORTTYPE");
        String strFullFileName = "";
        try {
            String strFileSuffix = "";
            if (StringHelper.compare(strExportType, "HTML", true) == 0) {
                strFileSuffix = "htm";
                this.getWebContext().getResponse().setContentType("text/html;charset=GBK");
                this.getWebContext().getResponse().setCharacterEncoding("GBK");
                strFullFileName = StringHelper.format("%1$s%2$s%3$s%4$s.%5$s", WebConfig.getCurrent().getTempPath(), this.getWebContext().getSessionId(), File.separator, strFileName, strFileSuffix);
                this.exportGridViewHTML(strFullFileName);
            } else {
                this.getWebContext().getResponse().setContentType("application/vnd.ms-excel;charset=GBK");
                this.getWebContext().getResponse().setCharacterEncoding("GBK");
                strFileSuffix = "xls";
                strFullFileName = StringHelper.format("%1$s%2$s%3$s%4$s.%5$s", WebConfig.getCurrent().getTempPath(), this.getWebContext().getSessionId(), File.separator, strFileName, strFileSuffix);
                ExportFilePage.downloadFile(strFullFileName, String.valueOf(strFileName) + "." + strFileSuffix, this.getWebContext().getResponse());
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return ajaxActionResult;
    }

    public void exportGridViewHTML(String strFullFileName) {
        FileInputStream fis = null;
        try {
            this.getWebContext().getResponse().getOutputStream().flush();
            fis = new FileInputStream(new File(strFullFileName));
            if (fis == null || fis.available() <= 0) {
                return;
            }
            try {
                byte[] bytes = new byte[fis.available()];
                int nCnt = fis.read(bytes);
                this.getWebContext().getResponse().getOutputStream().write(bytes);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

