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
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDESADetail;
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
        this.get(pSDEServiceAPI);
        PSDESADetailService pSDESADetailService = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDESADetail> arrayList = pSDEServiceAPI.getPSDESADetails();
        HashMap<String, PSDESADetail> hashMap = new HashMap<String, PSDESADetail>();
        for (PSDESADetail pSDESADetail2 : arrayList) {
            hashMap.put(pSDESADetail2.getPSDESADetailId(), pSDESADetail2);
            hashMap.put(pSDESADetail2.getUniqueTag(), pSDESADetail2);
        }
        String string2 = pSDEServiceAPI.getPSDEName();
        boolean bl = DataObject.getBoolValue((Integer)pSDEServiceAPI.getPSDE().getPSSystem().getServiceAPIFlag(), (boolean)false);
        bl = DataObject.getBoolValue((Integer)pSDEServiceAPI.getPSDE().getServiceAPIFlag(), (boolean)bl);
        if (DataObject.getBoolValue((Integer)pSDEServiceAPI.getEnableDEAction(), (boolean)bl)) {
            for (PSDEAction action : pSDEServiceAPI.getPSDE().getPSDEActions()) {
                string = StringHelper.format((String)"%1$s__DEACTION__%2$s", (Object)string2, (Object)action.getPSDEActionName()).toUpperCase();
                if (hashMap.containsKey(string)) continue;
                pSDESADetail = new PSDESADetail();
                pSDESADetail.setDetailType("DEACTION");
                pSDESADetail.setPSDEActionId(action.getPSDEActionId());
                pSDESADetail.setPSDEActionName(action.getPSDEActionName());
                pSDESADetail.setUniqueTag(string);
                if (StringHelper.compare((String)action.getPSDEActionName(), (String)"CREATE", (boolean)true) != 0 && StringHelper.compare((String)action.getPSDEActionName(), (String)"UPDATE", (boolean)true) != 0 && StringHelper.compare((String)action.getPSDEActionName(), (String)"REMOVE", (boolean)true) != 0 && StringHelper.compare((String)action.getPSDEActionName(), (String)"GET", (boolean)true) != 0) {
                    pSDESADetail.setCodeName(action.getCodeName());
                }
                if (DataObject.getBoolValue((Integer)action.getPubMode(), (boolean)bl)) {
                    pSDESADetail.setValidFlag(1);
                } else {
                    pSDESADetail.setValidFlag(0);
                }
                pSDESADetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                pSDESADetail.setMethodTag(StringHelper.format((String)"DEACTION__%1$s", (Object)action.getPSDEActionName()).toUpperCase());
                pSDESADetailService.create(pSDESADetail, false);
                hashMap.put(string, pSDESADetail);
            }
        }
        if (DataObject.getBoolValue((Integer)pSDEServiceAPI.getEnableDEDataSet(), (boolean)bl)) {
            for (PSDEDataSet dataSet : pSDEServiceAPI.getPSDE().getPSDEDataSets()) {
                string = StringHelper.format((String)"%1$s__FETCH__%2$s", (Object)string2, (Object)dataSet.getPSDEDataSetName()).toUpperCase();
                if (hashMap.containsKey(string)) continue;
                pSDESADetail = new PSDESADetail();
                pSDESADetail.setDetailType("FETCH");
                pSDESADetail.setPSDEDSId(dataSet.getPSDEDataSetId());
                pSDESADetail.setPSDEDSName(dataSet.getPSDEDataSetName());
                if (DataObject.getBoolValue((Integer)dataSet.getPubMode(), (boolean)bl)) {
                    pSDESADetail.setValidFlag(1);
                } else {
                    pSDESADetail.setValidFlag(0);
                }
                pSDESADetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
                pSDESADetail.setMethodTag(StringHelper.format((String)"FETCH__%1$s", (Object)dataSet.getPSDEDataSetName()).toUpperCase());
                pSDESADetailService.create(pSDESADetail, false);
                hashMap.put(string, pSDESADetail);
            }
        }
        String selectTag = StringHelper.format((String)"%1$s__SELECT", (Object)string2).toUpperCase();
        if (DataObject.getBoolValue((Integer)pSDEServiceAPI.getEnableSelect(), (boolean)bl) && !hashMap.containsKey(selectTag)) {
            PSDESADetail selectDetail = new PSDESADetail();
            selectDetail.setDetailType("SELECT");
            selectDetail.setPSDEServiceAPIId(pSDEServiceAPI.getPSDEServiceAPIId());
            selectDetail.setMethodTag("SELECT");
            selectDetail.setCodeName("Select");
            pSDESADetailService.create(selectDetail, false);
            hashMap.put(selectTag, selectDetail);
        }
    }
}
