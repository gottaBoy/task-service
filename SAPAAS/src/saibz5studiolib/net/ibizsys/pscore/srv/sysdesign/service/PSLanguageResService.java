/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLan;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLanBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLanService;
import net.ibizsys.pscore.srv.codelist.SysLanResTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSLanguageResService
extends PSLanguageResServiceBase {
    private static final Log log = LogFactory.getLog(PSLanguageResService.class);

    @Override
    protected boolean onFillEntityKeyValue(PSLanguageRes pSLanguageRes, boolean bl) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)pSLanguageRes.getPSModuleId())) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            Object object = pSLanguageRes.get("PSSYSTEMID");
            if (object == null) {
                object = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object);
            stringBuilderEx.append("||");
            stringBuilderEx.append("%1$s", (Object)pSLanguageRes.getPSModuleId());
            stringBuilderEx.append("||");
            Object object2 = pSLanguageRes.get("LANRESTYPE");
            if (object2 == null) {
                object2 = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object2);
            stringBuilderEx.append("||");
            Object object3 = pSLanguageRes.get("USERDATA");
            if (object3 == null) {
                object3 = "__EMTPY__";
            }
            stringBuilderEx.append("%1$s", object3);
            String string = stringBuilderEx.toString();
            pSLanguageRes.set(this.getPSLanguageResDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
            return true;
        }
        return super.onFillEntityKeyValue(pSLanguageRes, bl);
    }

    @Override
    protected void onBeforeCreate(PSLanguageRes pSLanguageRes) throws Exception {
        pSLanguageRes.setLanResTag(StringHelper.format((String)"%1$s.%2$s", (Object)pSLanguageRes.getLanResType(), (Object)pSLanguageRes.getUserData()));
        if (StringHelper.isNullOrEmpty((String)pSLanguageRes.getPSLanguageResName())) {
            SysLanResTypeCodeListModel sysLanResTypeCodeListModel = (SysLanResTypeCodeListModel)CodeListGlobal.getCodeList(SysLanResTypeCodeListModel.class);
            String string = sysLanResTypeCodeListModel.getCodeListText(pSLanguageRes.getLanResType(), true);
            pSLanguageRes.setPSLanguageResName(StringHelper.format((String)"%1$s[%2$s]", (Object)string, (Object)pSLanguageRes.getUserData()));
        }
        if (StringHelper.length((String)pSLanguageRes.getContent()) > 2000) {
            pSLanguageRes.setContent2(pSLanguageRes.getContent());
            pSLanguageRes.setContent(null);
        } else {
            pSLanguageRes.setContent2(null);
        }
        super.onBeforeCreate(pSLanguageRes);
    }

    @Override
    protected void onBeforeUpdate(PSLanguageRes pSLanguageRes) throws Exception {
        if (StringHelper.length((String)pSLanguageRes.getContent()) > 2000) {
            pSLanguageRes.setContent2(pSLanguageRes.getContent());
            pSLanguageRes.setContent(null);
        } else {
            pSLanguageRes.setContent2(null);
        }
        super.onBeforeUpdate(pSLanguageRes);
    }

    protected CallResult internalGet(PSLanguageRes pSLanguageRes, boolean bl) throws Exception {
        CallResult callResult = super.internalGet((IEntity)pSLanguageRes, bl);
        if (callResult.isOk() && !StringHelper.isNullOrEmpty((String)pSLanguageRes.getContent2())) {
            pSLanguageRes.setContent(pSLanguageRes.getContent2());
        }
        return callResult;
    }

    @Override
    protected void onInitLanItem(PSLanguageRes pSLanguageRes) throws Exception {
        Object object;
        Object object2;
        String string = "__SYSAPPLANMAP__";
        HashMap hashMap = null;
        IWebContext iWebContext = this.getWebContext();
        if (iWebContext != null && (object2 = iWebContext.getAttribute(string)) != null) {
            hashMap = (HashMap)object2;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
            object2 = new SelectContext();
            object2.set("pssystemid", (Object)pSLanguageRes.getPSSystemId());
            object2.setDEDataQueryName("CurSys");
            PSAppLanService pSAppLanService = (PSAppLanService)ServiceGlobal.getService(PSAppLanService.class, (SessionFactory)this.getSessionFactory());
            Serializable serializable = pSAppLanService.select((ISelectCond)object2);
            object = ((ArrayList)serializable).iterator();
            while (object.hasNext()) {
                PSAppLan pSAppLan = (PSAppLan)object.next();
                hashMap.put(pSAppLan.getPSLanguageId(), pSAppLan);
            }
            if (iWebContext != null) {
                iWebContext.setAttribute(string, (Object)hashMap);
            }
        }
        object2 = (PSLanguageItemService)ServiceGlobal.getService(PSLanguageItemService.class, (SessionFactory)this.getSessionFactory());
        for (Serializable serializable : hashMap.values()) {
            object = new PSLanguageItem();
            ((PSLanguageItemBase)object).setPSSystemId(pSLanguageRes.getPSSystemId());
            ((PSLanguageItemBase)object).setPSLanguageResId(pSLanguageRes.getPSLanguageResId());
            ((PSLanguageItemBase)object).setPSLanguageId(((PSAppLanBase)serializable).getPSLanguageId());
            if (((PSCoreSysServiceBaseBase)((Object)object2)).select(object, true)) continue;
            ((PSLanguageItemBase)object).setPSLanguageName(((PSAppLanBase)serializable).getPSLanguageName());
            ((PSLanguageItemBase)object).setPSLanguageResName(pSLanguageRes.getPSLanguageResName());
            ((PSLanguageItemBase)object).setPSSystemName(pSLanguageRes.getPSSystemName());
            ((PSCoreSysServiceBase)object2).create(object, false);
        }
    }

    @Override
    protected void onCreateShortTag(PSLanguageRes pSLanguageRes) throws Exception {
        String string;
        PSLanguageRes pSLanguageRes2;
        if (!pSLanguageRes.isFullEntity()) {
            this.get((IEntity)pSLanguageRes);
        }
        if (!StringHelper.isNullOrEmpty((String)pSLanguageRes.getShortTag())) {
            return;
        }
        String string2 = pSLanguageRes.getPSSystemId();
        PSSystem pSSystem = new PSSystem();
        pSSystem.setPSSystemId(string2);
        PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
        pSSystemService.get((IEntity)pSSystem);
        int n = DataObject.getIntegerValue((Object)pSSystem.getLanResMaxTag(), (Integer)1000);
        do {
            string = StringHelper.format((String)"U%1$s", (Object)(++n));
            pSLanguageRes2 = new PSLanguageRes();
            pSLanguageRes2.setShortTag(string);
            pSLanguageRes2.setPSSystemId(pSLanguageRes.getPSSystemId());
        } while (this.select(pSLanguageRes2, true));
        pSLanguageRes.setShortTag(string);
        this.update(pSLanguageRes);
        pSSystem.reset();
        pSSystem.setPSSystemId(string2);
        pSSystem.setLanResMaxTag(n);
        pSSystemService.update(pSSystem);
    }

    @Override
    protected void onAutoFillModule(PSLanguageRes pSLanguageRes) throws Exception {
        PSSystem pSSystem = PSLanguageResService.getCurrentPSSystem((IEntity)pSLanguageRes, this.getSessionFactory());
        PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.setIsNull("PSMODULEID");
        selectCond.set("PSSYSTEMID", (Object)pSSystem.getPSSystemId());
        ArrayList arrayList = this.select((ISelectCond)selectCond);
        for (PSLanguageRes pSLanguageRes2 : arrayList) {
            if (StringHelper.isNullOrEmpty((String)pSLanguageRes2.getPSDEId())) continue;
            PSDataEntity pSDataEntity = new PSDataEntity();
            pSDataEntity.setPSDataEntityId(pSLanguageRes2.getPSDEId());
            if (!pSDataEntityService.get((IEntity)pSDataEntity, true)) continue;
            PSLanguageRes pSLanguageRes3 = new PSLanguageRes();
            pSLanguageRes3.setPSLanguageResId(pSLanguageRes2.getPSLanguageResId());
            pSLanguageRes3.setPSModuleId(pSDataEntity.getPSModuleId());
            pSLanguageRes3.setPSModuleName(pSDataEntity.getPSModuleName());
            this.update(pSLanguageRes3, false);
        }
    }

    @Override
    public String getModelV2Tag(PSLanguageRes pSLanguageRes) {
        if (!StringHelper.isNullOrEmpty((String)pSLanguageRes.getCodeName())) {
            return pSLanguageRes.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSLanguageRes.getLanResTag())) {
            return pSLanguageRes.getLanResTag();
        }
        return super.getModelV2Tag(pSLanguageRes);
    }
}

