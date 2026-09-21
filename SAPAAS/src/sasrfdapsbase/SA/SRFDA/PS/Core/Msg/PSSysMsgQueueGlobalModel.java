/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Msg;

import SA.SRFDA.PS.Core.Msg.IPSSysMsgQueue;
import SA.SRFDA.PS.Core.Msg.PSSysMsgQueueImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysMsgQueue;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysMsgQueueGlobalModel
extends PSSystemGlobalModelBase<String, PSSysMsgQueue, IPSSysMsgQueue> {
    private static final Log log = LogFactory.getLog(PSSysMsgQueueGlobalModel.class);

    @Override
    protected PSSysMsgQueue GetObject(String strPSSysMsgQueueId) {
        if (this.isPrepareModels()) {
            return null;
        }
        return null;
    }

    @Override
    protected IPSSysMsgQueue OnCreateModelHelper(PSSysMsgQueue vt) throws Exception {
        PSSysMsgQueueImpl iPSSysMsgQueue = null;
        iPSSysMsgQueue = new PSSysMsgQueueImpl();
        iPSSysMsgQueue.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysMsgQueue;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysMsgQueue obj) {
        return false;
    }

    @Override
    protected IPSSysMsgQueue registerModel(PSSysMsgQueue vt) throws Exception {
        IPSSysMsgQueue iIPSSysMsgQueue = (IPSSysMsgQueue)this.InternalGetModelHelper(vt.getPSSYSMSGQUEUEID());
        if (iIPSSysMsgQueue != null) {
            return iIPSSysMsgQueue;
        }
        this.setModel(vt.getPSSYSMSGQUEUEID(), vt, null);
        return (IPSSysMsgQueue)this.FindModelHelper(vt.getPSSYSMSGQUEUEID());
    }

    @Override
    protected Vector<PSSysMsgQueue> getAllModels() throws Exception {
        Vector<PSSysMsgQueue> list = new Vector<PSSysMsgQueue>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysMsgQueues(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d88\u606f\u961f\u5217\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysMsgQueue vt) {
        return vt.getPSSYSMSGQUEUEID();
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysMsgQueue vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

