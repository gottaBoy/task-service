/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaCodeList;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSCodeListService
extends PSCodeListServiceBase {
    private static final Log log = LogFactory.getLog(PSCodeListService.class);

    @Override
    public void getDraft(PSCodeList pSCodeList) throws Exception {
        super.getDraft(pSCodeList);
        if (StringHelper.isNullOrEmpty((String)pSCodeList.getPSModuleId()) && pSCodeList.getPSDE() != null) {
            pSCodeList.setPSModuleId(pSCodeList.getPSDE().getPSModuleId());
            pSCodeList.setPSModuleName(pSCodeList.getPSDE().getPSModuleName());
        }
    }

    @Override
    protected void onBeforeCreate(PSCodeList pSCodeList) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSCodeList.getPSDynaInstId())) {
            pSCodeList.setDynaSysRefMode(2);
        }
        super.onBeforeCreate(pSCodeList);
    }

    @Override
    protected void onInitModel(PSCodeList pSCodeList) throws Exception {
        super.onInitModel(pSCodeList);
        this.initPSCodeListLanRes(pSCodeList);
    }

    protected void initPSCodeListLanRes(PSCodeList pSCodeList) throws Exception {
        Object object;
        PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
        PSCodeList pSCodeList2 = new PSCodeList();
        pSCodeList2.setPSCodeListId(pSCodeList.getPSCodeListId());
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSCodeList.getEmptyText()) && StringHelper.isNullOrEmpty((String)pSCodeList.getEmptyTextPSLanResId())) {
            PSLanguageRes pSLanguageRes = new PSLanguageRes();
            pSLanguageRes.setPSSystemId(pSCodeList.getPSSystemId());
            pSLanguageRes.setLanResType("CL.ITEM.LNAME");
            pSLanguageRes.setUserData(StringHelper.format((String)"%1$s.%2$s", (Object)pSCodeList.getCodeName(), (Object)"_EMTPY_").toUpperCase());
            if (!pSLanguageResService.select(pSLanguageRes, true)) {
                pSLanguageRes.setContent(pSCodeList.getEmptyText());
                pSLanguageResService.create(pSLanguageRes);
                pSCodeList2.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
                pSCodeList2.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                bl = true;
            }
        }
        object = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSCodeItem> arrayList = pSCodeList.getPSCodeItems();
        for (PSCodeItem pSCodeItem : arrayList) {
            if (StringHelper.isNullOrEmpty((String)pSCodeItem.getPSCodeItemName()) || !StringHelper.isNullOrEmpty((String)pSCodeItem.getTextPSLanResId())) continue;
            PSLanguageRes pSLanguageRes = new PSLanguageRes();
            pSLanguageRes.setPSSystemId(pSCodeList.getPSSystemId());
            pSLanguageRes.setLanResType("CL.ITEM.LNAME");
            pSLanguageRes.setUserData(StringHelper.format((String)"%1$s.%2$s", (Object)pSCodeList.getCodeName(), (Object)pSCodeItem.getCodeItemValue()).toUpperCase());
            if (pSLanguageResService.select(pSLanguageRes, true)) continue;
            pSLanguageRes.setContent(pSCodeItem.getPSCodeItemName());
            pSLanguageResService.create(pSLanguageRes);
            pSCodeItem.setTextPSLanResId(pSLanguageRes.getPSLanguageResId());
            pSCodeItem.setTextPSLanResName(pSLanguageRes.getPSLanguageResName());
            bl = true;
            ((PSCoreSysServiceBase)object).update(pSCodeItem, false);
        }
        if (bl) {
            this.update(pSCodeList2, false);
        }
    }

    @Override
    protected void onAfterCreate(PSCodeList pSCodeList) throws Exception {
        this.initPSDynaCodeList(pSCodeList);
        super.onAfterCreate(pSCodeList);
    }

    @Override
    protected void onAfterUpdate(PSCodeList pSCodeList) throws Exception {
        this.initPSDynaCodeList(pSCodeList);
        super.onAfterUpdate(pSCodeList);
    }

    protected void initPSDynaCodeList(PSCodeList pSCodeList) throws Exception {
        if (PSCodeListService.isImpSysModelNowEx()) {
            return;
        }
        if (!pSCodeList.isEnableDynaSysDirty()) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)pSCodeList.getEnableDynaSys(), (boolean)false)) {
            return;
        }
        if (pSCodeList.getPSSystem() == null) {
            return;
        }
        if (DataObject.getIntegerValue((Object)pSCodeList.getPSSystem().getEnableDynaSys(), (Integer)0) == 0) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u542f\u7528\u52a8\u6001\u7cfb\u7edf\u529f\u80fd\uff0c\u4e0d\u80fd\u542f\u7528\u4ee3\u7801\u8868\u7684\u52a8\u6001\u529f\u80fd"));
        }
        PSDynaCodeListService pSDynaCodeListService = (PSDynaCodeListService)ServiceGlobal.getService(PSDynaCodeListService.class, (SessionFactory)this.getSessionFactory());
        PSDynaCodeList pSDynaCodeList = new PSDynaCodeList();
        pSDynaCodeList.setPSDynaCodeListId(pSCodeList.getPSCodeListId());
        if (pSCodeList.isPSCodeListNameDirty()) {
            pSDynaCodeList.setPSDynaCodeListName(pSCodeList.getPSCodeListName());
        }
        pSDynaCodeList.setPSDynaSysId(pSCodeList.getPSSystem().getPSSystemId());
        pSDynaCodeList.setPSDynaSysName(pSCodeList.getPSSystem().getPSSystemName());
        pSDynaCodeListService.save(pSDynaCodeList);
    }

    @Override
    protected String getEntityFolderKeyValue(PSCodeList pSCodeList, PSSystem pSSystem) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSCodeList.getPSDEId())) {
            return PSModelFolderKeyHelper.getModelKey(pSCodeList, pSSystem, "PSCODELIST_SYS", "", this.getSessionFactory());
        }
        return super.getEntityFolderKeyValue(pSCodeList, pSSystem);
    }
}
