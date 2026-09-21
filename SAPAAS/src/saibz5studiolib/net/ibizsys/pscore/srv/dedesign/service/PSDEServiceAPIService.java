/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetailBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEServiceAPI;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEServiceAPIServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEServiceAPIService
extends PSDEServiceAPIServiceBase {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIService.class);

    @Override
    protected void onBeforeCreate(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSDEServiceAPI.getPSDEServiceAPIName())) {
            pSDEServiceAPI.setPSDEServiceAPIName(pSDEServiceAPI.getPSDEName());
        }
        super.onBeforeCreate(pSDEServiceAPI);
    }

    @Override
    protected void onRebuildDetails(PSDEServiceAPI pSDEServiceAPI) throws Exception {
        PSDESADetail pSDESADetail;
        String string;
        EntityBase entityBase;
        Object object;
        Object object2;
        this.get((IEntity)pSDEServiceAPI);
        PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDESADetail> arrayList = pSDEServiceAPI.getPSDESADetails();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        for (PSDESADetail pSDESADetail2 : arrayList) {
            hashMap.put(pSDESADetail2.getPSDESADetailId(), pSDESADetail2);
            hashMap.put(pSDESADetail2.getUniqueTag(), pSDESADetail2);
        }
        String string2 = pSDEServiceAPI.getPSDEName();
        boolean bl = DataObject.getBoolValue((Integer)pSDEServiceAPI.getPSDE().getPSSystem().getServiceAPIFlag(), (boolean)false);
        bl = DataObject.getBoolValue((Integer)pSDEServiceAPI.getPSDE().getServiceAPIFlag(), (boolean)bl);
        if (DataObject.getBoolValue((Integer)pSDEServiceAPI.getEnableDEAction(), (boolean)bl)) {
            object2 = pSDEServiceAPI.getPSDE().getPSDEActions();
            object = ((ArrayList)object2).iterator();
            while (object.hasNext()) {
                entityBase = object.next();
                string = StringHelper.format((String)"%1$s__DEACTION__%2$s", (Object)string2, (Object)entityBase.getPSDEActionName()).toUpperCase();
                if (hashMap.containsKey(string)) continue;
                pSDESADetail = new PSDESADetail();
                pSDESADetail.setDetailType("DEACTION");
                pSDESADetail.setPSDEActionId(entityBase.getPSDEActionId());
                pSDESADetail.setPSDEActionName(entityBase.getPSDEActionName());
                pSDESADetail.setUniqueTag(string);
                if (StringHelper.compare((String)entityBase.getPSDEActionName(), (String)"CREATE", (boolean)true) != 0 && StringHelper.compare((String)entityBase.getPSDEActionName(), (String)"UPDATE", (boolean)true) != 0 && StringHelper.compare((String)entityBase.getPSDEActionName(), (String)"REMOVE", (boolean)true) != 0 && StringHelper.compare((String)entityBase.getPSDEActionName(), (String)"GET", (boolean)true) != 0) {
                    pSDESADetail.setCodeName(entityBase.getCodeName());
                }
                if (DataObject.getBoolValue((Integer)entityBase.getPubMode(), (boolean)bl)) {
                    pSDESADetail.setValidFlag(1);
                } else {
                    pSDESADetail.setValidFlag(0);
                }
                pSDESADetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                pSDESADetail.setMethodTag(StringHelper.format((String)"DEACTION__%1$s", (Object)entityBase.getPSDEActionName()).toUpperCase());
                pSDESADetailService.create(pSDESADetail, false);
                hashMap.put(string, pSDESADetail);
            }
        }
        if (DataObject.getBoolValue((Integer)pSDEServiceAPI.getEnableDEDataSet(), (boolean)bl)) {
            object2 = pSDEServiceAPI.getPSDE().getPSDEDataSets();
            object = ((ArrayList)object2).iterator();
            while (object.hasNext()) {
                entityBase = (PSDEDataSet)((Object)object.next());
                string = StringHelper.format((String)"%1$s__FETCH__%2$s", (Object)string2, (Object)entityBase.getPSDEDataSetName()).toUpperCase();
                if (hashMap.containsKey(string)) continue;
                pSDESADetail = new PSDESADetail();
                pSDESADetail.setDetailType("FETCH");
                pSDESADetail.setPSDEDSId(entityBase.getPSDEDataSetId());
                pSDESADetail.setPSDEDSName(entityBase.getPSDEDataSetName());
                if (DataObject.getBoolValue((Integer)entityBase.getPubMode(), (boolean)bl)) {
                    pSDESADetail.setValidFlag(1);
                } else {
                    pSDESADetail.setValidFlag(0);
                }
                pSDESADetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                pSDESADetail.setMethodTag(StringHelper.format((String)"FETCH__%1$s", (Object)entityBase.getPSDEDataSetName()).toUpperCase());
                pSDESADetailService.create(pSDESADetail, false);
                hashMap.put(string, pSDESADetail);
            }
        }
        if (DataObject.getBoolValue((Integer)pSDEServiceAPI.getEnableSelect(), (boolean)bl) && !hashMap.containsKey(object2 = StringHelper.format((String)"%1$s__SELECT", (Object)string2).toUpperCase())) {
            object = new PSDESADetail();
            ((PSDESADetailBase)object).setDetailType("SELECT");
            ((PSDESADetailBase)object).setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            ((PSDESADetailBase)object).setMethodTag("SELECT");
            ((PSDESADetailBase)object).setCodeName("Select");
            pSDESADetailService.create(object, false);
            hashMap.put(object2, object);
        }
    }
}

