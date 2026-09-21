/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jspsmart.upload.SmartFile
 *  com.jspsmart.upload.SmartUpload
 *  javax.servlet.ServletException
 */
package net.ibizsys.paas.web.util;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.servlet.ServletException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.ibizsys.psrt.srv.web.WebContext;

public class UploadFileSavePage2
extends Page {
    protected String strProcessInfo = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        String strFileId = this.getWebContext().getParamValue("FILEID");
        String strFileLocalPath = WebConfig.getCurrent().getFilePath();
        if (StringHelper.isNullOrEmpty(strFileLocalPath)) {
            this.strProcessInfo = "alert('\u7cfb\u7edf\u6ca1\u6709\u914d\u7f6e\u6587\u4ef6\u5b58\u50a8\u8def\u5f84');";
            return;
        }
        SmartUpload su = this.createSmartUpload();
        su.upload();
        int nCount = su.getFiles().getCount();
        if (nCount == 0) {
            this.strProcessInfo = "alert('\u6ca1\u6709\u4efb\u4f55\u4e0a\u4f20\u6587\u4ef6');";
            return;
        }
        String strFileFolder = StringHelper.format("%1$tY-%1$tm-%1$td", new Date());
        strFileFolder = String.valueOf(strFileFolder) + File.separator;
        strFileFolder = String.valueOf(strFileFolder) + KeyValueHelper.genGuidEx();
        strFileFolder = String.valueOf(strFileFolder) + File.separator;
        File dir = new File(String.valueOf(strFileLocalPath) + strFileFolder);
        dir.mkdirs();
        String strFilename = "";
        String strFilePathName = String.valueOf(strFileLocalPath) + strFileFolder;
        int nFileSize = 0;
        int i = 0;
        while (i < nCount) {
            SmartFile file = su.getFiles().getFile(i);
            nFileSize = file.getSize();
            strFilename = file.getFileName();
            if (!StringHelper.isNullOrEmpty(strFilename)) {
                strFilename = this.getRealFileName(strFilename);
                strFilePathName = String.valueOf(strFilePathName) + strFilename;
                file.saveAs(strFilePathName);
                break;
            }
            ++i;
        }
        net.ibizsys.psrt.srv.common.entity.File file = new net.ibizsys.psrt.srv.common.entity.File();
        if (!StringHelper.isNullOrEmpty(strFileId)) {
            file.setFileId(strFileId);
        }
        file.setFileSize(nFileSize);
        file.setFileName(strFilename);
        file.setLocalPath(String.valueOf(strFileFolder) + strFilename);
        FileService fileService = (FileService)ServiceGlobal.getService(FileService.class, this.getSessionFactory());
        StringHelper.isNullOrEmpty(WebContext.getParentDEId(this.getWebContext()));
        this.onBeforeSaveFile(file);
        if (StringHelper.isNullOrEmpty(strFileId)) {
            fileService.create(file);
        } else {
            fileService.update(file);
        }
        this.onAfterSaveFile(file);
        this.strProcessInfo = file.getFileId();
        this.getResponse().getWriter().write(this.strProcessInfo);
    }

    protected void onBeforeSaveFile(net.ibizsys.psrt.srv.common.entity.File file) throws Exception {
    }

    protected void onAfterSaveFile(net.ibizsys.psrt.srv.common.entity.File file) throws Exception {
    }

    public String getFileId() {
        return this.strProcessInfo;
    }

    protected String getRealFileName(String strFilename) throws UnsupportedEncodingException {
        return strFilename;
    }

    protected SmartUpload createSmartUpload() throws ServletException {
        SmartUpload su = new SmartUpload();
        su.initialize(this.getPageContext());
        return su;
    }
}

