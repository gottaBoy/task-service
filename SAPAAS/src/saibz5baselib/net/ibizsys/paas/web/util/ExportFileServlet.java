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
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.service.FileService;

public class ExportFileServlet
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
        String strFileLocalPath;
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        String strFileId = this.getWebContext().getParamValue("FILEID");
        String strRotate = this.getWebContext().getParamValue("ROTATE");
        if (StringHelper.isNullOrEmpty(strFileId)) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u6587\u4ef6\u4fe1\u606f"));
        }
        net.ibizsys.psrt.srv.common.entity.File file = new net.ibizsys.psrt.srv.common.entity.File();
        FileService fileService = (FileService)ServiceGlobal.getService(FileService.class, this.getSessionFactory());
        file.setFileId(strFileId);
        fileService.get(file);
        String strPreview = this.getWebContext().getParamValue("PREVIEW");
        if (StringHelper.isNullOrEmpty(strPreview)) {
            strPreview = "TRUE";
        }
        if (StringHelper.isNullOrEmpty(strFileLocalPath = WebConfig.getCurrent().getFilePath())) {
            throw new Exception(StringHelper.format("\u7cfb\u7edf\u6ca1\u6709\u914d\u7f6e\u6587\u4ef6\u5b58\u50a8\u8def\u5f84"));
        }
        String strLocalPath = "";
        String strFileName = "";
        if (StringHelper.compare(strPreview, "TRUE", true) != 0) {
            strLocalPath = file.getLocalPath2();
            strFileName = file.getFileName2();
        }
        if (StringHelper.isNullOrEmpty(strLocalPath)) {
            strLocalPath = file.getLocalPath();
        }
        if (StringHelper.isNullOrEmpty(strFileName)) {
            strFileName = file.getFileName();
        }
        String strTempFilePath = String.valueOf(strFileLocalPath) + strLocalPath;
        String strNewFileName = new String(strFileName.getBytes("GB2312"), "ISO-8859-1");
        if (!StringHelper.isNullOrEmpty(strRotate)) {
            try {
                String strTmp = String.valueOf(strTempFilePath.substring(0, strTempFilePath.indexOf("."))) + "_" + strRotate + ".png";
                File tmpFile = new File(strTmp);
                if (tmpFile.exists()) {
                    strTempFilePath = strTmp;
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        ExportFileServlet.downloadFile(strTempFilePath, strNewFileName, this.getWebContext().getResponse());
        return ajaxActionResult;
    }

    public static void downloadFile(String filePath, String fileName, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            try {
                File file = new File(filePath);
                if (file != null && file.isFile() && file.canRead()) {
                    int length;
                    response.setCharacterEncoding("utf-8");
                    response.setContentType(WebUtility.getHttpContentType(fileName.substring(fileName.lastIndexOf("."))));
                    response.setHeader("Pragma", "No-cache");
                    response.setHeader("Cache-Control", "no-cache");
                    response.setDateHeader("Expires", 0L);
                    response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
                    response.setHeader("Cache-Control", "max-age=0");
                    inputStream = new FileInputStream(file);
                    outputStream = response.getOutputStream();
                    byte[] b = new byte[1024];
                    while ((length = inputStream.read(b)) > 0) {
                        outputStream.write(b, 0, length);
                    }
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

