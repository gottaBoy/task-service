/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.devcenter.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.DevCenterFileTypeCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDCDBInstBKService
extends PSDCDBInstBKServiceBase {
    private static final Log log = LogFactory.getLog(PSDCDBInstBKService.class);

    @Override
    protected void onAfterCreate(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        PSDevCenterFileService pSDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterFile pSDevCenterFile = new PSDevCenterFile();
        pSDevCenterFile.setFileType(DevCenterFileTypeCodeListModel.FILE);
        pSDevCenterFile.setBizTag("SRFBACKUP");
        pSDevCenterFile.setFilePath(pSDCDBInstBK.getBKFilePath());
        pSDevCenterFile.setPSDevCenterId(pSDCDBInstBK.getPSDevCenterId());
        pSDevCenterFile.setPSDevCenterName(pSDCDBInstBK.getPSDevCenterName());
        pSDevCenterFile.setPSTaskServerId(pSDCDBInstBK.getPSTaskServerId());
        pSDevCenterFile.setPSTaskServerName(pSDCDBInstBK.getPSTaskServerName());
        pSDevCenterFile.setPSDevCenterFileName(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u5907\u4efd\u6587\u4ef6", (Object)pSDCDBInstBK.getPSDCDBInstBKName()));
        pSDevCenterFile.setOwnerId(pSDCDBInstBK.getPSDCDBInstBKId());
        pSDevCenterFile.setOwnerName(pSDCDBInstBK.getPSDCDBInstBKName());
        pSDevCenterFile.setOwnerType("PSDCDBINSTBK");
        pSDevCenterFile.setOwnerTypeName("\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b\u5907\u4efd");
        pSDevCenterFile.setPSDevCenterFileId(pSDCDBInstBK.getPSDCDBInstBKId());
        if (pSDCDBInstBK.getBackupSize() != null) {
            pSDevCenterFile.setFileObjSize((double)pSDCDBInstBK.getBackupSize());
        }
        pSDevCenterFileService.create(pSDevCenterFile, false);
        super.onAfterCreate(pSDCDBInstBK);
    }

    @Override
    protected void onAfterUpdate(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        PSDevCenterFileService pSDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterFile pSDevCenterFile = new PSDevCenterFile();
        pSDevCenterFile.setPSDevCenterFileId(pSDCDBInstBK.getPSDCDBInstBKId());
        if (pSDCDBInstBK.isFullBKFilePathDirty()) {
            pSDevCenterFile.setFilePath(pSDCDBInstBK.getFullBKFilePath());
        }
        if (pSDCDBInstBK.isBackupSizeDirty()) {
            if (pSDCDBInstBK.getBackupSize() == null) {
                pSDevCenterFile.setFileObjSize(0.0);
            } else {
                pSDevCenterFile.setFileObjSize((double)pSDCDBInstBK.getBackupSize());
            }
        }
        pSDevCenterFileService.update(pSDevCenterFile, false);
        super.onAfterUpdate(pSDCDBInstBK);
    }

    @Override
    protected void onAfterRemove(PSDCDBInstBK pSDCDBInstBK) throws Exception {
        PSDevCenterFileService pSDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
        PSDevCenterFile pSDevCenterFile = new PSDevCenterFile();
        pSDevCenterFile.setPSDevCenterFileId(pSDCDBInstBK.getPSDCDBInstBKId());
        if (pSDevCenterFileService.checkKey(pSDevCenterFile) == 1) {
            pSDevCenterFileService.remove((IEntity)pSDevCenterFile);
        }
        super.onAfterRemove(pSDCDBInstBK);
    }
}

