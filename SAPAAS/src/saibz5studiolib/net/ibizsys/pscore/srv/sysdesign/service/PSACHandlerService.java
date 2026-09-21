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
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerServiceBase;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSACHandlerService
extends PSACHandlerServiceBase {
    private static final Log log = LogFactory.getLog(PSACHandlerService.class);

    @Override
    protected void onFillParentInfo_PSDE(PSACHandler pSACHandler, PSDataEntity pSDataEntity) throws Exception {
        super.onFillParentInfo_PSDE(pSACHandler, pSDataEntity);
        pSACHandler.setPSSystemId(pSDataEntity.getPSSystemId());
        pSACHandler.setPSSystemName(pSDataEntity.getPSSystemName());
    }

    @Override
    protected String getEntityFolderKeyValue(PSACHandler pSACHandler, PSSystem pSSystem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSACHandler.getPSDEId())) {
            return PSModelFolderKeyHelper.getModelKey((IEntity)pSACHandler, pSSystem, "PSACHANDLER_SYS", "", this.getSessionFactory());
        }
        return super.getEntityFolderKeyValue(pSACHandler, pSSystem);
    }
}

