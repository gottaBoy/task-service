/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile;
import net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysFile;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysFileServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysFileService
extends PSSysFileServiceBase {
    private static final Log log = LogFactory.getLog(PSSysFileService.class);

    @Override
    protected void onBeforeCreate(PSSysFile pSSysFile) throws Exception {
        Object object = pSSysFile.get("FILEPATH");
        if (StringHelper.isNullOrEmpty((Object)object)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6587\u4ef6\u8def\u5f84");
        }
        String string = (String)object;
        PSNDFile pSNDFile = new PSNDFile();
        pSNDFile.setFilePath(string);
        try {
            PSNDFileService.putToRemote(pSNDFile);
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u5b58\u50a8\u7f51\u76d8\u6587\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()));
        }
        pSSysFile.setFileObjSize(pSNDFile.getFileObjSize());
        pSSysFile.setPSNDFileId(pSNDFile.getPSNDFileId());
        super.onBeforeCreate(pSSysFile);
    }
}

