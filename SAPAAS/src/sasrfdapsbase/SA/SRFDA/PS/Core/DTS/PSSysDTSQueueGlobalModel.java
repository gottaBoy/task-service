/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DTS;

import SA.SRFDA.PS.Core.DTS.IPSSysDTSQueue;
import SA.SRFDA.PS.Core.DTS.PSSysDTSQueueImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysDTSQueue;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDTSQueueGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDTSQueue, IPSSysDTSQueue> {
    private static final Log log = LogFactory.getLog(PSSysDTSQueueGlobalModel.class);

    @Override
    protected PSSysDTSQueue GetObject(String strPSSysDTSQueueId) {
        PSSysDTSQueue psSysDTSQueue = new PSSysDTSQueue();
        CallResult callResult = this.iPSModelHelper.getPSSysDTSQueue(strPSSysDTSQueueId, psSysDTSQueue);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5206\u5e03\u5f0f\u4e8b\u52a1\u961f\u5217\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDTSQueueId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysDTSQueue;
    }

    @Override
    protected IPSSysDTSQueue OnCreateModelHelper(PSSysDTSQueue vt) throws Exception {
        PSSysDTSQueueImpl iPSSysDTSQueue = null;
        iPSSysDTSQueue = new PSSysDTSQueueImpl();
        iPSSysDTSQueue.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDTSQueue;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDTSQueue obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysDTSQueue registerModel(PSSysDTSQueue vt) throws Exception {
        IPSSysDTSQueue iIPSSysDTSQueue = (IPSSysDTSQueue)this.InternalGetModelHelper(vt.getPSDEDTSQUEUEID());
        if (iIPSSysDTSQueue != null) {
            return iIPSSysDTSQueue;
        }
        this.setModel(vt.getPSDEDTSQUEUEID(), vt, null);
        return (IPSSysDTSQueue)this.FindModelHelper(vt.getPSDEDTSQUEUEID());
    }

    @Override
    protected Vector<PSSysDTSQueue> getAllModels() throws Exception {
        Vector<PSSysDTSQueue> list = new Vector<PSSysDTSQueue>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDTSQueues(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5206\u5e03\u5f0f\u4e8b\u52a1\u961f\u5217\u5bf9\u8c61\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDTSQueue vt) {
        return vt.getPSDEDTSQUEUEID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }
}

