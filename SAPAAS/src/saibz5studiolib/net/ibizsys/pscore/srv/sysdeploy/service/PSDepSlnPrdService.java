/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdeploy.service;

import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnPrd;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPrdServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDepSlnPrdService
extends PSDepSlnPrdServiceBase {
    private static final Log log = LogFactory.getLog(PSDepSlnPrdService.class);

    @Override
    protected void onBeforeCreate(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        if (DataObject.getBoolValue((Integer)pSDepSlnPrd.getEnaDynamicMode(), (boolean)false)) {
            this.fillPSSysModelInst(pSDepSlnPrd);
        }
        super.onBeforeCreate(pSDepSlnPrd);
    }

    @Override
    protected void onBeforeUpdate(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        PSDepSlnPrd pSDepSlnPrd2;
        if (DataObject.getBoolValue((Integer)pSDepSlnPrd.getEnaDynamicMode(), (boolean)false) && StringHelper.isNullOrEmpty((String)(pSDepSlnPrd2 = (PSDepSlnPrd)this.getLast(pSDepSlnPrd)).getPSSysModelInstId())) {
            this.fillPSSysModelInst(pSDepSlnPrd);
        }
        super.onBeforeUpdate(pSDepSlnPrd);
    }

    protected void fillPSSysModelInst(PSDepSlnPrd pSDepSlnPrd) throws Exception {
        PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("INSTSTATE", (Object)"20");
        selectCond.setFetchFirst(true);
        ArrayList arrayList = pSSysModelInstService.select((ISelectCond)selectCond);
        if (arrayList.size() == 0) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b"));
        }
        PSSysModelInst pSSysModelInst = (PSSysModelInst)arrayList.get(0);
        pSDepSlnPrd.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSDepSlnPrd.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
        pSSysModelInst.setPSDevCenterId(pSDepSlnPrd.getPSDepSln().getPSDevCenterId());
        pSSysModelInst.setPSDevCenterName(pSDepSlnPrd.getPSDepSln().getPSDevCenterName());
        String string = StringHelper.format((String)"[\u90e8\u7f72\u65b9\u6848]%1$s\\%2$s", (Object)pSDepSlnPrd.getPSDepSlnName(), (Object)pSDepSlnPrd.getPSDepSlnPrdName());
        pSSysModelInst.setRefInfo(string);
        pSSysModelInst.setInstState("30");
        pSSysModelInstService.update(pSSysModelInst);
    }
}

