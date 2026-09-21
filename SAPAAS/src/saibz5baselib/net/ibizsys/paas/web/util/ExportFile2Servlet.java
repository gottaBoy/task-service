/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package net.ibizsys.paas.web.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.ExportFileServlet;

public class ExportFile2Servlet
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
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        String strFileName = this.getWebContext().getParamValue("FILEID");
        if (StringHelper.isNullOrEmpty(strFileName)) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u6587\u4ef6\u4fe1\u606f"));
        }
        String strTempFilePath = StringHelper.format("%1$s%2$s", WebConfig.getCurrent().getTempPath(), strFileName);
        ExportFileServlet.downloadFile(strTempFilePath, strFileName, this.getWebContext().getResponse());
        return ajaxActionResult;
    }
}

