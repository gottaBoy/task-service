/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
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
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSModuleService
extends PSModuleServiceBase {
    private static final Log log = LogFactory.getLog(PSModuleService.class);

    @Override
    protected void onBeforeCreate(PSModule pSModule) throws Exception {
        String string;
        if (StringHelper.isNullOrEmpty((String)pSModule.getCodeName())) {
            PSModule pSModule2;
            string = "Module";
            int n = 1;
            do {
                if (n > 1) {
                    string = StringHelper.format((String)"Module%1$s", (Object)n);
                }
                ++n;
                pSModule2 = new PSModule();
                pSModule2.setSessionFactory(this.getSessionFactory());
                pSModule2.setPSSystemId(pSModule.getPSSystemId());
                pSModule2.setCodeName(string);
            } while (pSModule2.select(true));
            pSModule.setCodeName(string);
        }
        if (pSModule.getOrderValue() == null) {
            string = new SelectContext();
            string.set("PSSYSTEMID", (Object)pSModule.getPSSystemId());
            string.addSelectField(SelectField.create((String)"ORDERVALUE", (String)"ORDERVALUE", (String)"MAX"));
            ArrayList arrayList = this.selectEx((ISelectContext)string);
            int n = 1000;
            if (arrayList.size() > 0 && ((PSModule)arrayList.get(0)).getOrderValue() != null) {
                n = ((PSModule)arrayList.get(0)).getOrderValue();
                n += 10;
            }
            pSModule.setOrderValue(n);
        }
        super.onBeforeCreate(pSModule);
    }

    @Override
    protected void onBeforeUpdate(PSModule pSModule) throws Exception {
        PSModule pSModule2 = (PSModule)this.getLast((IEntity)pSModule);
        if (pSModule.isPSSysModelGroupIdDirty()) {
            PSDataEntityService pSDataEntityService;
            ArrayList<PSDataEntity> arrayList;
            String string = pSModule.getPSSysModelGroupId();
            boolean bl = false;
            boolean bl2 = bl = StringHelper.compare((String)pSModule2.getPSSysModelGroupId(), (String)string, (boolean)false) != 0;
            if (bl && (arrayList = (pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory())).selectByPSModule(pSModule)) != null && arrayList.size() != 0) {
                for (PSDataEntity pSDataEntity : arrayList) {
                    PSDataEntity pSDataEntity2 = new PSDataEntity();
                    pSDataEntity2.setPSDataEntityId(pSDataEntity.getPSDataEntityId());
                    pSDataEntity2.setPSSysModelGroupId(pSModule.getPSSysModelGroupId());
                    pSDataEntity2.setPSSysModelGroupName(pSModule.getPSSysModelGroupName());
                    pSDataEntityService.update(pSDataEntity2, false);
                }
            }
        }
        super.onBeforeUpdate(pSModule);
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }
}

