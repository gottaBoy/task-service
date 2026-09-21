/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web.util;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.util.ExportFilePage;

public class ExportFilePage2
extends Page {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        String strFileName = this.getWebContext().getParamValue("FILEID");
        if (StringHelper.isNullOrEmpty(strFileName)) {
            throw new Exception(StringHelper.format("\u6ca1\u6709\u6307\u5b9a\u6587\u4ef6\u4fe1\u606f"));
        }
        String strTempFilePath = StringHelper.format("%1$s%2$s", WebConfig.getCurrent().getTempPath(), strFileName);
        ExportFilePage.downloadFile(strTempFilePath, strFileName, this.getResponse());
    }
}

