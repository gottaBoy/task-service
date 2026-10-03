/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppLocalDE;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLocalDEService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPIBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDESARS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPIBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDESARSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysServiceAPIServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysServiceAPIService
extends PSSysServiceAPIServiceBase {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIService.class);

    @Override
    protected void onGenUniqueTag(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        pSSysServiceAPI.setUniqueTag(KeyValueHelper.genGuidEx());
    }

    @Override
    protected void onCreateSubSysFile(PSSysServiceAPI pSSysServiceAPI) throws Exception {
    }

    @Override
    protected void onBeforeCreate(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        String string;
        if (pSSysServiceAPI.getPSSystem() != null && !StringHelper.isNullOrEmpty((String)(string = pSSysServiceAPI.getPSSystem().getPSDevSlnSysId()))) {
            PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = new PSDevSlnSysAPI();
            pSSysServiceAPI.copyTo((IDataObject)pSDevSlnSysAPI, false);
            pSDevSlnSysAPI.setPSDevSlnSysId(string);
            pSDevSlnSysAPI.setPSDevSlnSysAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
            EntityBase.setLastUpdateDate(pSDevSlnSysAPI, null);
            pSDevSlnSysAPIService.create(pSDevSlnSysAPI, false);
            pSSysServiceAPI.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
        }
        super.onBeforeCreate(pSSysServiceAPI);
    }

    @Override
    protected void onAfterCreate(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        super.onAfterCreate(pSSysServiceAPI);
    }

    @Override
    protected void onBeforeUpdate(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        Object object;
        String string = null;
        if (pSSysServiceAPI.getPSSystem() != null) {
            string = pSSysServiceAPI.getPSSystem().getPSDevSlnSysId();
        } else {
            object = (PSSysServiceAPI)this.getLast(pSSysServiceAPI);
            if (((PSSysServiceAPIBase)object).getPSSystem() != null) {
                string = ((PSSysServiceAPIBase)object).getPSSystem().getPSDevSlnSysId();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            object = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = new PSDevSlnSysAPI();
            pSSysServiceAPI.copyTo((IDataObject)pSDevSlnSysAPI, false);
            pSDevSlnSysAPI.setPSDevSlnSysId(string);
            if (!StringHelper.isNullOrEmpty((String)pSSysServiceAPI.getPSSysServiceAPIName())) {
                pSDevSlnSysAPI.setPSDevSlnSysAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
            }
            EntityBase.setLastUpdateDate(pSDevSlnSysAPI, null);
            ((PSDevSlnSysAPIService)object).save(pSDevSlnSysAPI, false);
            pSSysServiceAPI.setPSDevSlnSysAPIId(pSDevSlnSysAPI.getPSDevSlnSysAPIId());
        }
        super.onBeforeUpdate(pSSysServiceAPI);
    }

    @Override
    protected void onAfterUpdate(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        super.onAfterUpdate(pSSysServiceAPI);
    }

    @Override
    protected void onBeforeRemove(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        String string;
        PSSysServiceAPI pSSysServiceAPI2 = (PSSysServiceAPI)this.getLast(pSSysServiceAPI);
        if (pSSysServiceAPI2.getPSSystem() != null && !StringHelper.isNullOrEmpty((String)(string = pSSysServiceAPI2.getPSSystem().getPSDevSlnSysId()))) {
            PSDevSlnSysAPIService pSDevSlnSysAPIService = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysAPI pSDevSlnSysAPI = new PSDevSlnSysAPI();
            pSSysServiceAPI.copyTo((IDataObject)pSDevSlnSysAPI, false);
            pSDevSlnSysAPI.setPSDevSlnSysId(string);
            pSDevSlnSysAPIService.fillEntityKeyValue(pSDevSlnSysAPI);
            if (pSDevSlnSysAPIService.checkKey(pSDevSlnSysAPI) == 1) {
                pSDevSlnSysAPIService.remove(pSDevSlnSysAPI);
            }
        }
        super.onBeforeRemove(pSSysServiceAPI);
    }

    @Override
    protected void onRebuildByAppDE(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        this.get(pSSysServiceAPI);
        PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysApp> arrayList = pSSysAppService.selectByPSSysServiceAPI(pSSysServiceAPI);
        ArrayList<PSDEServiceAPI> arrayList2 = pSSysServiceAPI.getPSDEServiceAPIs();
        HashMap<String, PSDEServiceAPI> hashMap = new HashMap<String, PSDEServiceAPI>();
        HashMap<String, PSDEServiceAPI> hashMap2 = new HashMap<String, PSDEServiceAPI>();
        for (PSDEServiceAPI object2 : arrayList2) {
            if (!hashMap.containsKey(object2.getPSDEId()) || DataObject.getBoolValue((Integer)object2.getMajorFlag(), (boolean)true)) {
                hashMap.put(object2.getPSDEId(), object2);
            }
            hashMap2.put(object2.getPSDEServiceAPIName().toUpperCase(), object2);
        }
        PSDEServiceAPIService pSDEServiceAPIService = (PSDEServiceAPIService)ServiceGlobal.getService(PSDEServiceAPIService.class, (SessionFactory)this.getSessionFactory());
        PSAppLocalDEService pSAppLocalDEService = (PSAppLocalDEService)ServiceGlobal.getService(PSAppLocalDEService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysApp pSSysApp : arrayList) {
            ArrayList<PSAppLocalDE> arrayList3 = pSSysApp.getPSAppLocalDEs();
            for (PSAppLocalDE pSAppLocalDE : arrayList3) {
                Object object;
                if (!StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSDEServiceAPIId()) || StringHelper.isNullOrEmpty((String)pSAppLocalDE.getPSDEId()) || DataObject.getIntegerValue((Object)pSAppLocalDE.getEnableStorage(), (Integer)0) == 1) continue;
                PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)hashMap.get(pSAppLocalDE.getPSDEId());
                if (pSDEServiceAPI == null) {
                    pSDEServiceAPI = new PSDEServiceAPI();
                    pSDEServiceAPI.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
                    pSDEServiceAPI.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                    pSDEServiceAPI.setMajorFlag(1);
                    pSDEServiceAPI.setPSDEId(pSAppLocalDE.getPSDEId());
                    pSDEServiceAPI.setPSDEName(pSAppLocalDE.getPSDEName());
                    object = pSAppLocalDE.getPSDEName();
                    int n = 2;
                    while (hashMap2.containsKey(((String)object).toUpperCase())) {
                        object = StringHelper.format((String)"%1$s%2$s", (Object)pSAppLocalDE.getPSDEName(), (Object)n);
                        ++n;
                    }
                    pSDEServiceAPI.setPSDEServiceAPIName((String)object);
                    pSDEServiceAPIService.create(pSDEServiceAPI);
                    hashMap.put(pSDEServiceAPI.getPSDEId(), pSDEServiceAPI);
                    hashMap2.put(pSDEServiceAPI.getPSDEServiceAPIName().toUpperCase(), pSDEServiceAPI);
                }
                PSAppLocalDE pSAppLocalDEUpdate = new PSAppLocalDE();
                pSAppLocalDEUpdate.setPSAppLocalDEId(pSAppLocalDE.getPSAppLocalDEId());
                pSAppLocalDEUpdate.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                pSAppLocalDEUpdate.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
                pSAppLocalDEUpdate.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
                pSAppLocalDEService.sysUpdate(pSAppLocalDEUpdate, false);
            }
        }
    }

    @Override
    protected void onRebuildDESARS(PSSysServiceAPI pSSysServiceAPI) throws Exception {
        Object object;
        Object serializable;
        Object serializable2;
        SelectCond pSDESARS2;
        this.get(pSSysServiceAPI);
        ArrayList<PSDEServiceAPI> arrayList = pSSysServiceAPI.getPSDEServiceAPIs();
        ArrayList<PSDESARS> arrayList2 = pSSysServiceAPI.getPSDESARSes();
        HashMap<String, PSDEServiceAPI> hashMap = new HashMap<String, PSDEServiceAPI>();
        HashMap<String, PSDEServiceAPI> hashMap2 = new HashMap<String, PSDEServiceAPI>();
        for (PSDEServiceAPI object22 : arrayList) {
            if (!hashMap.containsKey(object22.getPSDEId()) || DataObject.getBoolValue((Integer)object22.getMajorFlag(), (boolean)true)) {
                hashMap.put(object22.getPSDEId(), object22);
            }
            hashMap2.put(object22.getPSDEServiceAPIId(), object22);
        }
        HashMap hashMap3 = new HashMap();
        for (PSDESARS pSDESARS : arrayList2) {
            serializable2 = (PSDEServiceAPI)hashMap2.get(pSDESARS.getPPSDEServiceAPIId());
            serializable = (PSDEServiceAPI)hashMap2.get(pSDESARS.getCPSDEServiceAPIId());
            if (serializable2 == null || serializable == null) continue;
            object = StringHelper.format((String)"%1$s|%2$s", (Object)((PSDEServiceAPIBase)serializable2).getPSDEId(), (Object)((PSDEServiceAPI)serializable).getPSDEId());
            hashMap3.put(object, pSDESARS);
            hashMap3.put(pSDESARS.getPSDESARSName(), pSDESARS);
        }
        PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
        pSDESARS2 = new SelectCond();
        pSDESARS2.set("DERTYPE", "DER1N");
        pSDESARS2.set("PSSYSTEMID", pSSysServiceAPI.getPSSystemId());
        serializable2 = pSDERService.select((ISelectCond)pSDESARS2);
        pSDESARS2.reset();
        pSDESARS2.set("DERTYPE", "DERCUSTOM");
        pSDESARS2.set("DERSUBTYPE", "DER1N");
        pSDESARS2.set("PSSYSTEMID", pSSysServiceAPI.getPSSystemId());
        serializable = pSDERService.select((ISelectCond)pSDESARS2);
        ((ArrayList)serializable2).addAll((ArrayList)serializable);
        object = (PSDESARSService)ServiceGlobal.getService(PSDESARSService.class, (SessionFactory)this.getSessionFactory());
        Iterator iterator = ((ArrayList)serializable2).iterator();
        while (iterator.hasNext()) {
            String string;
            int n;
            PSDER pSDER = (PSDER)iterator.next();
            if (!DataObject.getBoolValue((Integer)pSDER.getValidFlag(), (boolean)true)) continue;
            PSDEServiceAPI pSDEServiceAPI = (PSDEServiceAPI)hashMap.get(pSDER.getMajorPSDEId());
            PSDEServiceAPI pSDEServiceAPI2 = (PSDEServiceAPI)hashMap.get(pSDER.getMinorPSDEId());
            if (pSDEServiceAPI == null || pSDEServiceAPI2 == null || ((n = DataObject.getIntegerValue((Object)pSDER.getMasterRS(), (Integer)0).intValue()) & 1) == 0 || hashMap3.containsKey(string = StringHelper.format((String)"%1$s|%2$s", (Object)pSDER.getMajorPSDEId(), (Object)pSDER.getMinorPSDEId()))) continue;
            PSDESARS pSDESARS3 = new PSDESARS();
            pSDESARS3.setPSDERId(pSDER.getPSDERId());
            pSDESARS3.setPSDERName(pSDER.getPSDERName());
            pSDESARS3.setPPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            pSDESARS3.setPPSDEServiceAPIName(pSDEServiceAPI.getPSDEServiceAPIName());
            pSDESARS3.setCPSDEServiceAPIId(pSDEServiceAPI2.getPSDEServiceAPIId());
            pSDESARS3.setCPSDEServiceAPIName(pSDEServiceAPI2.getPSDEServiceAPIName());
            pSDESARS3.setPSSysServiceAPIId(pSSysServiceAPI.getPSSysServiceAPIId());
            pSDESARS3.setPSSysServiceAPIName(pSSysServiceAPI.getPSSysServiceAPIName());
            String string2 = pSDER.getPSDERName();
            int n2 = 2;
            while (hashMap3.containsKey(string2.toUpperCase())) {
                string2 = StringHelper.format((String)"%1$s%2$s", (Object)pSDER.getPSDERName(), (Object)n2);
                ++n2;
            }
            pSDESARS3.setPSDESARSName(string2);
            ((PSCoreSysServiceBaseBase)((Object)object)).create(pSDESARS3);
            hashMap3.put(string, pSDESARS3);
            hashMap3.put(pSDESARS3.getPSDESARSName(), pSDESARS3);
        }
    }

    @Override
    public boolean fillModelV2Key(PSSysServiceAPI pSSysServiceAPI, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = super.fillModelV2Key(pSSysServiceAPI, objectNode, string, string2, bl);
        if (bl) {
            pSSysServiceAPI.setPSDevSlnSysAPIId(null);
        }
        return bl2;
    }
}
