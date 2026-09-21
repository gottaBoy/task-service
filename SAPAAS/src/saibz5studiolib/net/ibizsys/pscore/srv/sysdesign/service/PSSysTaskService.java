/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
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
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTaskData;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskDataService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysTaskService
extends PSSysTaskServiceBase {
    private static final Log log = LogFactory.getLog(PSSysTaskService.class);

    @Override
    protected void onAfterRemove(PSSysTask pSSysTask) throws Exception {
        PSSysTask pSSysTask2 = (PSSysTask)this.getLast((IEntity)pSSysTask);
        if (!StringHelper.isNullOrEmpty((String)pSSysTask2.getModelTypeId())) {
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)pSSysTask2.getModelTypeId());
            IService iService = iDataEntityModel.getService(this.getSessionFactory());
            IEntity iEntity = iDataEntityModel.createEntity();
            iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)pSSysTask2.getPSObjId());
            iService.get(iEntity);
            if (!StringHelper.isNullOrEmpty((Object)iEntity.get("TODOTASK"))) {
                iEntity.reset();
                iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)pSSysTask2.getPSObjId());
                iEntity.set("TODOTASK", null);
                iService.update(iEntity, false);
            }
        }
        super.onAfterRemove(pSSysTask);
    }

    @Override
    protected boolean isPrepareLastForRemove() {
        return true;
    }

    @Override
    protected void onMark(PSSysTask pSSysTask) throws Exception {
        pSSysTask.setImportanceFlag(1);
        this.update(pSSysTask);
    }

    @Override
    protected void onUnmark(PSSysTask pSSysTask) throws Exception {
        pSSysTask.setImportanceFlag(0);
        this.update(pSSysTask);
    }

    @Override
    protected void onBeforeUpdate(PSSysTask pSSysTask) throws Exception {
        String string = DataObject.getStringValue((IDataObject)pSSysTask, (String)"srfmemo", (String)"");
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSSysTaskDataService pSSysTaskDataService = (PSSysTaskDataService)ServiceGlobal.getService(PSSysTaskDataService.class, (SessionFactory)this.getSessionFactory());
            PSSysTaskData pSSysTaskData = new PSSysTaskData();
            pSSysTaskData.setPSSysTaskId(pSSysTask.getPSSysTaskId());
            pSSysTaskData.setPSSysTaskName(pSSysTask.getPSSysTaskName());
            pSSysTaskData.setContent(string);
            if (string.length() > 90) {
                pSSysTaskData.setPSSysTaskDataName(string.substring(0, 90) + "...");
            } else {
                pSSysTaskData.setPSSysTaskDataName(string);
            }
            pSSysTaskDataService.create(pSSysTaskData, false);
        }
        super.onBeforeUpdate(pSSysTask);
    }
}

