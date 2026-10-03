/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import java.io.File;
import java.sql.Timestamp;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.DevCenterFileTypeCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileServiceBase;
import net.ibizsys.pscore.srv.util.PSFileUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevCenterFileService
extends PSDevCenterFileServiceBase {
    private static final Log log = LogFactory.getLog(PSDevCenterFileService.class);

    @Override
    protected void onCalcFolderSize(PSDevCenterFile pSDevCenterFile) throws Exception {
        if (!pSDevCenterFile.isFullEntity()) {
            this.get(pSDevCenterFile);
        }
        if (pSDevCenterFile.getFileType() != null && pSDevCenterFile.getFileType().equals(DevCenterFileTypeCodeListModel.FOLDER) && !StringHelper.isNullOrEmpty((String)pSDevCenterFile.getFilePath())) {
            long l = PSFileUtil.getFolderSize(new File(pSDevCenterFile.getFilePath()));
            double d = (double)l / 1024.0;
            pSDevCenterFile.setFileObjSize(d);
            pSDevCenterFile.setLastCalcTime(new Timestamp(System.currentTimeMillis()));
            this.update(pSDevCenterFile);
        }
    }
}

