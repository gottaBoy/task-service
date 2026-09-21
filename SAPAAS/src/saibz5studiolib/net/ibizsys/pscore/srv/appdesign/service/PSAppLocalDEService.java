/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.appdesign.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDEBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModuleBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrlBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.liteutil.entity.PSAppViewLite;
import net.ibizsys.pscore.srv.liteutil.service.PSAppViewLiteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSAppLocalDEService
extends PSAppLocalDEServiceBase {
    private static final Log log = LogFactory.getLog(PSAppLocalDEService.class);

    @Override
    protected void onRebuildAll(PSAppLocalDE pSAppLocalDE) throws Exception {
        Object object;
        Object object2;
        Serializable serializable;
        Object object32;
        PSAppViewLite pSAppViewLite2;
        if (this.getWebContext() == null) {
            return;
        }
        String string = WebContext.getParentKey((IWebContext)this.getWebContext());
        String string2 = WebContext.getParentDEId((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new ErrorException(4);
        }
        SelectCond selectCond = new SelectCond();
        PSAppViewLiteService pSAppViewLiteService = (PSAppViewLiteService)ServiceGlobal.getService(PSAppViewLiteService.class, (SessionFactory)this.getSessionFactory());
        selectCond.setIsNotNull("PSDEVIEWBASEID");
        selectCond.set("PSSYSAPPID", (Object)string);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap<String, String> hashMap2 = new HashMap<String, String>();
        ArrayList arrayList = pSAppViewLiteService.select((ISelectCond)selectCond);
        for (PSAppViewLite pSAppViewLite2 : arrayList) {
            hashMap.put(pSAppViewLite2.getPSDEId(), pSAppViewLite2.getPSDEName());
            hashMap2.put(pSAppViewLite2.getPSAppViewId(), pSAppViewLite2.getPSDEId());
        }
        PSDEViewCtrlService pSDEViewCtrlService = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        pSAppViewLite2 = new SelectContext();
        pSAppViewLite2.setDEDataQueryName("CurApp");
        pSAppViewLite2.set("pssysappid", string);
        pSAppViewLite2.setIsNotNull("PSDEID");
        ArrayList arrayList2 = pSDEViewCtrlService.select((ISelectCond)pSAppViewLite2);
        for (Object object32 : arrayList2) {
            if (StringHelper.isNullOrEmpty((String)((PSDEViewCtrlBase)object32).getPSDEId())) continue;
            hashMap.put(((PSDEViewCtrlBase)object32).getPSDEId(), ((PSDEViewCtrlBase)object32).getPSDEName());
        }
        selectCond.reset();
        selectCond.set("PSSYSAPPID", (Object)string);
        ArrayList arrayList3 = this.select((ISelectCond)selectCond);
        object32 = arrayList3.iterator();
        while (object32.hasNext()) {
            serializable = (PSAppLocalDE)object32.next();
            if (StringHelper.isNullOrEmpty((String)((PSAppLocalDEBase)serializable).getPSAppModuleId())) continue;
            hashMap.remove(((PSAppLocalDEBase)serializable).getPSDEId());
        }
        if (hashMap.size() == 0) {
            return;
        }
        object32 = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
        selectCond.reset();
        selectCond.set("PSSYSAPPID", (Object)string);
        serializable = object32.select((ISelectCond)selectCond);
        HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
        if (((ArrayList)serializable).size() > 0) {
            object2 = ((ArrayList)serializable).iterator();
            while (object2.hasNext()) {
                object = (PSAppModule)object2.next();
                if (StringHelper.isNullOrEmpty((String)((PSAppModuleBase)object).getPSModuleId())) continue;
                hashMap3.put(((PSAppModuleBase)object).getPSModuleId(), object);
            }
        }
        object2 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
        object = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        for (Map.Entry entry : hashMap.entrySet()) {
            PSAppLocalDE pSAppLocalDE2 = new PSAppLocalDE();
            pSAppLocalDE2.setPSDEId((String)entry.getKey());
            pSAppLocalDE2.setPSDEName((String)entry.getValue());
            pSAppLocalDE2.setPSSysAppId(string);
            pSAppLocalDE2.setPSAppLocalDEName((String)entry.getValue());
            pSAppLocalDE2.setPSAppModuleId(null);
            pSAppLocalDE2.setPSAppModuleName(null);
            this.save((IEntity)pSAppLocalDE2, false);
        }
    }

    @Override
    protected void onBeforeCreate(PSAppLocalDE pSAppLocalDE) throws Exception {
        pSAppLocalDE.setPSAppModuleId(null);
        pSAppLocalDE.setPSAppModuleName(null);
        if (StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSAppLocalDEName())) {
            if (!StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSDEName())) {
                pSAppLocalDE.setPSAppLocalDEName(pSAppLocalDE.getPSDEName());
            } else if (!StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSDEId())) {
                pSAppLocalDE.setPSAppLocalDEName(pSAppLocalDE.getPSDE().getPSDataEntityName());
            }
        }
        super.onBeforeCreate(pSAppLocalDE);
    }

    @Override
    protected boolean onFillEntityKeyValue(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        if (!bl && !DataObject.getBoolValue((Integer)pSAppLocalDE.getDefaultFlag(), (boolean)true)) {
            pSAppLocalDE.set(this.getDEModel().getUniTagDEField().getName(), KeyValueHelper.genGuidEx());
            return false;
        }
        return super.onFillEntityKeyValue(pSAppLocalDE, bl);
    }

    protected CallResult internalGet(PSAppLocalDE pSAppLocalDE, boolean bl) throws Exception {
        CallResult callResult = super.internalGet((IEntity)pSAppLocalDE, bl);
        if (callResult.isOk()) {
            if (pSAppLocalDE.getDefaultFlag() == null) {
                if (StringHelper.compare((String)pSAppLocalDE.getPSAppLocalDEId(), (String)KeyValueHelper.genUniqueId((String)pSAppLocalDE.getPSSysAppId(), (String)pSAppLocalDE.getPSDEId()), (boolean)false) == 0) {
                    pSAppLocalDE.setDefaultFlag(1);
                } else {
                    pSAppLocalDE.setDefaultFlag(0);
                }
            }
            if (!PSAppLocalDEService.isImpSysModelNowEx() && StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSSysServiceAPIId()) && !StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSDEServiceAPIId()) && pSAppLocalDE.getPSDEServiceAPI() != null) {
                pSAppLocalDE.setPSSysServiceAPIId(pSAppLocalDE.getPSDEServiceAPI().getPSSysServiceAPIId());
                pSAppLocalDE.setPSSysServiceAPIName(pSAppLocalDE.getPSDEServiceAPI().getPSSysServiceAPIName());
            }
        }
        return callResult;
    }

    @Override
    public void getDraft(PSAppLocalDE pSAppLocalDE) throws Exception {
        super.getDraft(pSAppLocalDE);
        if (StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSSysServiceAPIId()) && pSAppLocalDE.getPSSysApp() != null) {
            pSAppLocalDE.setPSSysServiceAPIId(pSAppLocalDE.getPSSysApp().getPSSysServiceAPIId());
            pSAppLocalDE.setPSSysServiceAPIName(pSAppLocalDE.getPSSysApp().getPSSysServiceAPIName());
        }
    }

    @Override
    protected boolean fillCheckFieldDupRuleSelectCond(SelectContext selectContext, IDataEntityModel iDataEntityModel, String string, String[] stringArray, PSAppLocalDE pSAppLocalDE, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0) {
            return super.fillCheckFieldDupRuleSelectCond(selectContext, iDataEntityModel, string, new String[]{"PSSYSAPPID", "PPSAPPLOCALDEID"}, pSAppLocalDE, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0) {
            return super.fillCheckFieldDupRuleSelectCond(selectContext, iDataEntityModel, string, new String[]{"PSSYSAPPID", "PSDEID"}, pSAppLocalDE, bl, bl2);
        }
        return super.fillCheckFieldDupRuleSelectCond(selectContext, iDataEntityModel, string, stringArray, pSAppLocalDE, bl, bl2);
    }

    @Override
    public String getModelV2ResPath(IEntity iEntity, boolean bl) throws Exception {
        Object object = iEntity.get("DEFAULTFLAG");
        if (object == null) {
            String string = DataObject.getStringValue((Object)iEntity.get("PSAPPLOCALDEID"), null);
            String string2 = DataObject.getStringValue((Object)iEntity.get("PSSYSAPPID"), null);
            String string3 = DataObject.getStringValue((Object)iEntity.get("PSDEID"), null);
            if (!(StringHelper.isNullOrEmpty((String)string) || StringHelper.isNullOrEmpty((String)string2) || StringHelper.isNullOrEmpty((String)string3))) {
                if (StringHelper.compare((String)string, (String)KeyValueHelper.genUniqueId((String)string2, (String)string3), (boolean)false) == 0) {
                    iEntity.set("DEFAULTFLAG", (Object)1);
                } else {
                    iEntity.set("DEFAULTFLAG", (Object)0);
                }
            }
        }
        return super.getModelV2ResPath(iEntity, bl);
    }

    @Override
    public Object getDataContextValue(PSAppLocalDE pSAppLocalDE, String string, IDataContextParam iDataContextParam) throws Exception {
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDESERVICEAPI", (boolean)true) == 0 && StringHelper.compare((String)string, (String)"pssysserviceapiid", (boolean)true) == 0) {
            if (pSAppLocalDE.getPSSysApp() != null) {
                return pSAppLocalDE.getPSSysApp().getPSSysServiceAPIId();
            }
            return null;
        }
        return super.getDataContextValue(pSAppLocalDE, string, iDataContextParam);
    }
}

