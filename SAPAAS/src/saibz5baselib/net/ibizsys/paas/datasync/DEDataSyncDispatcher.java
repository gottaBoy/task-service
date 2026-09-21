/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.datasync;

import net.ibizsys.paas.core.DEDataChangeDispatcherBase;
import net.ibizsys.paas.core.IDEDataChangeDispatchParam;
import net.ibizsys.paas.core.IDEDataSyncOut;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.DataSyncOut;
import net.ibizsys.psrt.srv.common.service.DataSyncOutService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDataSyncDispatcher
extends DEDataChangeDispatcherBase {
    private static final Log log = LogFactory.getLog(DEDataSyncDispatcher.class);
    private DataSyncOutService dataSyncOutService = null;

    @Override
    protected void onInit() throws Exception {
        this.dataSyncOutService = (DataSyncOutService)ServiceGlobal.getService(DataSyncOutService.class);
        super.onInit();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void onDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception {
        iDataEntity = iDEDataChangeDispatchParam.getDataEntity();
        iDEDataSyncOuts = iDataEntity.getDEDataSyncs(false);
        if (iDEDataSyncOuts != null) ** GOTO lbl13
        return;
lbl-1000:
        // 1 sources

        {
            iDEDataSyncOut = (IDEDataSyncOut)iDEDataSyncOuts.next();
            if (!this.onTestDispatch(iDEDataChangeDispatchParam, iDEDataSyncOut)) continue;
            dataSyncOut = new DataSyncOut();
            iDEDataChangeDispatchParam.getDEDataChg().copyTo(dataSyncOut, false);
            dataSyncOut.setSyncAgent(iDEDataSyncOut.getSyncAgent());
            dataSyncOut.getEventType().intValue();
            this.dataSyncOutService.create(dataSyncOut, false);
lbl13:
            // 3 sources

            ** while (iDEDataSyncOuts.hasNext())
        }
lbl14:
        // 1 sources

    }

    protected boolean onTestDispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam, IDEDataSyncOut iDEDataSyncOut) throws Exception {
        if ((iDEDataChangeDispatchParam.getDEDataChg().getEventType() & iDEDataSyncOut.getEventType()) == 0) {
            return false;
        }
        if (StringHelper.isNullOrEmpty(iDEDataSyncOut.getTestDEActionName())) {
            return true;
        }
        IDataEntityModel iDataEntityModel = (IDataEntityModel)iDEDataSyncOut.getDataEntity();
        iDEDataChangeDispatchParam.getEntity().remove("SRFRET");
        iDataEntityModel.getService().executeAction(iDEDataSyncOut.getTestDEActionName(), iDEDataChangeDispatchParam.getEntity());
        boolean bRet = DataObject.getBoolValue(iDEDataChangeDispatchParam.getEntity(), "SRFRET", false);
        iDEDataChangeDispatchParam.getEntity().remove("SRFRET");
        return bRet;
    }
}

