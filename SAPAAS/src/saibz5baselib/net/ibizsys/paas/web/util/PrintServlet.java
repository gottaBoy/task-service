/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.report.IPrintService;
import net.ibizsys.paas.report.PrintServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrintServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(PrintServlet.class);
    private String strContentType = "";
    private String strFileFolder = "";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.strContentType = config.getInitParameter("CONTENTTYPE");
        if (StringHelper.isNullOrEmpty(this.strContentType)) {
            this.strContentType = "PDF";
        }
        this.strFileFolder = config.getInitParameter("FILEFOLDER");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        try {
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent(iWebContext);
            this.processPrint();
            this.resetCurrent();
            return;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            this.resetCurrent();
            return;
        }
    }

    protected void processPrint() throws Exception {
        String strPrintId = WebContext.getPrintId(this.getWebContext());
        String strKeys = WebContext.getKeys(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strKeys)) {
            strKeys = WebContext.getKey(this.getWebContext());
        }
        IPrintService iPrintService = PrintServiceGlobal.getPrintService(strPrintId);
        String strReportFile = iPrintService.getPrintFile(strKeys, this.getWebContext(), null, this.strContentType, this.strFileFolder);
        PrintServlet.sendBackFile(strReportFile, this.strContentType, this.getWebContext().getRequest(), this.getWebContext().getResponse());
    }

    protected static boolean sendBackFile(String strReportFile, String strReportType, HttpServletRequest request, HttpServletResponse response) {
        boolean bRet = true;
        try {
            if (StringHelper.compare(strReportType, "PDF", true) == 0) {
                response.setContentType("application/pdf");
            }
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
                    bRet = false;
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
        catch (Exception ex) {
            bRet = false;
            ex.printStackTrace();
        }
        return bRet;
    }
}

