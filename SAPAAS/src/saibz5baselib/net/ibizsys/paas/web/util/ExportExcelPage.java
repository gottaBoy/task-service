/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.util.ExportFilePage;

public class ExportExcelPage
extends Page {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        String strFileName = this.getWebContext().getParamValue("FILEID");
        if (StringHelper.isNullOrEmpty(strFileName)) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u6587\u4ef6\u4fe1\u606f"));
        }
        String strExportType = this.getWebContext().getParamValue("EXPORTTYPE");
        String strFullFileName = "";
        try {
            String strFileSuffix = "";
            if (StringHelper.compare(strExportType, "HTML", true) == 0) {
                strFileSuffix = "htm";
                this.getResponse().setContentType("text/html;charset=GBK");
                this.getResponse().setCharacterEncoding("GBK");
                strFullFileName = StringHelper.format("%1$s%2$s%3$s%4$s.%5$s", WebConfig.getCurrent().getTempPath(), this.getWebContext().getSessionId(), File.separator, strFileName, strFileSuffix);
                this.exportGridViewHTML(strFullFileName);
            } else {
                this.getResponse().setContentType("application/vnd.ms-excel;charset=GBK");
                this.getResponse().setCharacterEncoding("GBK");
                strFileSuffix = "xls";
                strFullFileName = StringHelper.format("%1$s%2$s%3$s%4$s.%5$s", WebConfig.getCurrent().getTempPath(), this.getWebContext().getSessionId(), File.separator, strFileName, strFileSuffix);
                ExportFilePage.downloadFile(strFullFileName, String.valueOf(strFileName) + "." + strFileSuffix, this.getResponse());
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void exportGridViewHTML(String strFullFileName) {
        FileInputStream fis = null;
        try {
            this.getResponse().getOutputStream().flush();
            fis = new FileInputStream(new File(strFullFileName));
            if (fis == null || fis.available() <= 0) {
                return;
            }
            try {
                byte[] bytes = new byte[fis.available()];
                int nCnt = fis.read(bytes);
                this.getResponse().getOutputStream().write(bytes);
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

