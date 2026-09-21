/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemData;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemHis;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemHisBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemDataService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemHisService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysReqItemService
extends PSSysReqItemServiceBase {
    private static final Log log = LogFactory.getLog(PSSysReqItemService.class);

    @Override
    protected void onBeforeUpdate(PSSysReqItem pSSysReqItem) throws Exception {
        Object object;
        Object object2;
        int n;
        PSSysReqItem pSSysReqItem2 = (PSSysReqItem)this.getLast((IEntity)pSSysReqItem);
        int n2 = DataObject.getIntegerValue((Object)pSSysReqItem2.getVer(), (Integer)1);
        if (n2 != (n = DataObject.getIntegerValue((Object)pSSysReqItem.getVer(), (Integer)1).intValue())) {
            object2 = (PSSysReqItemHisService)ServiceGlobal.getService(PSSysReqItemHisService.class, (SessionFactory)this.getSessionFactory());
            object = new PSSysReqItemHis();
            pSSysReqItem2.copyTo((IDataObject)object, false);
            ((PSSysReqItemHisBase)object).setPSSysReqItemHisName(pSSysReqItem2.getPSSysReqItemName());
            ((PSSysReqItemHisBase)object).setVer(n2);
            ((PSCoreSysServiceBase)object2).create(object, false);
        }
        if (!StringHelper.isNullOrEmpty((String)(object2 = DataObject.getStringValue((IDataObject)pSSysReqItem, (String)"srfmemo", (String)"")))) {
            object = (PSSysReqItemDataService)ServiceGlobal.getService(PSSysReqItemDataService.class, (SessionFactory)this.getSessionFactory());
            PSSysReqItemData pSSysReqItemData = new PSSysReqItemData();
            pSSysReqItemData.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
            pSSysReqItemData.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
            pSSysReqItemData.setContent((String)object2);
            if (((String)object2).length() > 90) {
                pSSysReqItemData.setPSSysReqItemDataName(((String)object2).substring(0, 90) + "...");
            } else {
                pSSysReqItemData.setPSSysReqItemDataName((String)object2);
            }
            ((PSCoreSysServiceBase)object).create(pSSysReqItemData, false);
        }
        super.onBeforeUpdate(pSSysReqItem);
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    @Override
    protected void onAfterCreate(PSSysReqItem pSSysReqItem) throws Exception {
        this.syncMOSFileWiki(pSSysReqItem);
        super.onAfterCreate(pSSysReqItem);
    }

    @Override
    protected void onAfterUpdate(PSSysReqItem pSSysReqItem) throws Exception {
        this.syncMOSFileWiki(pSSysReqItem);
        super.onAfterUpdate(pSSysReqItem);
    }

    protected void syncMOSFileWiki(PSSysReqItem pSSysReqItem) throws Exception {
        PSMOSFile pSMOSFile;
        if (PSSysReqItemService.getMOSVer() == 2 && PSSysReqItemService.isEnableGitLabPlugin() && !StringHelper.isNullOrEmpty((String)pSSysReqItem.getCodeName()) && (pSMOSFile = this.getFile((IEntity)pSSysReqItem)) != null && pSSysReqItem.isReqContentDirty()) {
            this.internalUpdateFileWiki(pSMOSFile, pSSysReqItem.getReqContent());
        }
    }

    protected void onAfterGet(PSSysReqItem pSSysReqItem) throws Exception {
        String string;
        PSMOSFile pSMOSFile;
        if (PSSysReqItemService.getMOSVer() == 2 && PSSysReqItemService.isEnableGitLabPlugin() && !StringHelper.isNullOrEmpty((String)pSSysReqItem.getCodeName()) && (pSMOSFile = this.getFile((IEntity)pSSysReqItem)) != null && !StringHelper.isNullOrEmpty((String)(string = this.internalGetFileWiki(pSMOSFile)))) {
            pSSysReqItem.setReqContent(string);
        }
        super.onAfterGet((IEntity)pSSysReqItem);
    }
}

