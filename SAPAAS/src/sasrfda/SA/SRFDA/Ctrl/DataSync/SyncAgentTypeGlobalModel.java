/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.SyncAgentType;
import SA.SRFDA.Ctrl.DataSync.ISyncAgentTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SyncAgentTypeGlobalModel
extends BaseDAGlobalModel<String, SyncAgentType, ISyncAgentTypeHelper> {
    private static final Log log = LogFactory.getLog(SyncAgentTypeGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected SyncAgentType GetObject(String objObjectId) {
        SyncAgentType syncAgentType = new SyncAgentType();
        CallResult callRsult = this.iDAGlobalHelper.getDAModelHelper().GetSyncAgentType(objObjectId, syncAgentType);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u540c\u6b65\u4ee3\u7406\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo()));
            return null;
        }
        return syncAgentType;
    }

    @Override
    protected Boolean TestObjectRenew(SyncAgentType obj) {
        return false;
    }

    @Override
    protected ISyncAgentTypeHelper OnCreateModelHelper(SyncAgentType syncAgentType) throws Exception {
        String strHelperObject = "";
        strHelperObject = "SA.SRFDA.Ctrl.DataSync.SyncAgentTypeHelper";
        Object objSyncAgentTypeHelper = ObjectHelper.Create((String)strHelperObject);
        if (objSyncAgentTypeHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u540c\u6b65\u4ee3\u7406\u7c7b\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61[%2$s]", (Object)syncAgentType.getSYNCAGENTTYPEID(), (Object)strHelperObject));
        }
        if (!(objSyncAgentTypeHelper instanceof ISyncAgentTypeHelper)) {
            throw new Exception(StringHelper.Format((String)"\u540c\u6b65\u4ee3\u7406\u7c7b\u578b[%1$s]\u8f85\u52a9\u5bf9\u8c61[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)syncAgentType.getSYNCAGENTTYPEID(), (Object)strHelperObject));
        }
        ISyncAgentTypeHelper iSyncAgentTypeHelper = (ISyncAgentTypeHelper)objSyncAgentTypeHelper;
        iSyncAgentTypeHelper.Init(this.iDAGlobalHelper, syncAgentType);
        return iSyncAgentTypeHelper;
    }
}

