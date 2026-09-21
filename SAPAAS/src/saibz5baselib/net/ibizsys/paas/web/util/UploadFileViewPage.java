/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web.util;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;

public class UploadFileViewPage
extends Page {
    protected String getFileType() {
        return this.getWebContext().getParamValue("FILETYPE");
    }

    protected int getFileCount() {
        String strFileCount = this.getWebContext().getParamValue("FIELCOUNT");
        if (StringHelper.isNullOrEmpty(strFileCount)) {
            return 0;
        }
        return Integer.parseInt(strFileCount);
    }
}

