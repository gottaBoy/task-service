/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DTS;

import SA.SRFDA.PS.Core.DataEntity.DTS.IPSDEDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.DTS.PSDEDTSQueueImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityGlobalModelBase;
import SA.SRFDA.PS.Data.PSDEDTSQueue;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDTSQueueGlobalModel
extends PSDataEntityGlobalModelBase<String, PSDEDTSQueue, IPSDEDTSQueue> {
    private static final Log log = LogFactory.getLog(PSDEDTSQueueGlobalModel.class);
    private IPSDEDTSQueue defaultPSDEDTSQueue = null;

    @Override
    protected PSDEDTSQueue GetObject(String strPSDEDTSQueueId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDEDTSQueueId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSDEDTSQueue OnCreateModelHelper(PSDEDTSQueue vt) throws Exception {
        PSDEDTSQueueImpl iPSDEDTSQueue = new PSDEDTSQueueImpl();
        iPSDEDTSQueue.init(this.iDAGlobalHelper, this.getPSDataEntity(), vt);
        return iPSDEDTSQueue;
    }

    @Override
    protected Boolean TestObjectRenew(PSDEDTSQueue obj) {
        return false;
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
    protected Vector<PSDEDTSQueue> getAllModels() throws Exception {
        Vector<PSDEDTSQueue> psDEDTSQueueList = new Vector<PSDEDTSQueue>();
        CallResult callResult = this.iPSModelHelper.getPSDEDTSQueues(this.getPSDataEntity().getId(), psDEDTSQueueList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u5b9e\u4f53\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psDEDTSQueueList;
    }

    @Override
    protected IPSDEDTSQueue registerModel(PSDEDTSQueue vt) throws Exception {
        IPSDEDTSQueue iPSDTSQueue = (IPSDEDTSQueue)this.InternalGetModelHelper(vt.getPSDEDTSQUEUEID());
        if (iPSDTSQueue != null) {
            return iPSDTSQueue;
        }
        this.setModel(vt.getPSDEDTSQUEUEID(), vt, null);
        IPSDEDTSQueue iPSDEDTSQueue = (IPSDEDTSQueue)this.FindModelHelper(vt.getPSDEDTSQUEUEID());
        if (iPSDEDTSQueue.isDefault()) {
            this.defaultPSDEDTSQueue = iPSDEDTSQueue;
        }
        return iPSDEDTSQueue;
    }

    @Override
    protected String getObjectId(PSDEDTSQueue vt) {
        return vt.getPSDEDTSQUEUEID();
    }

    public IPSDEDTSQueue getDefaultPSDEDTSQueue() {
        this.preloadModels();
        return this.defaultPSDEDTSQueue;
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSDEDTSQueue vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

