/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataSync;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DataSyncAgent;
import SA.SRFDA.Ctrl.Data.SyncAgentType;
import SA.SRFDA.Ctrl.DataSync.IDataSyncEngine;
import SA.SRFDA.Ctrl.DataSync.ISyncAgentTypeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SyncAgentTypeHelper
extends BaseDAObjectHelper
implements ISyncAgentTypeHelper {
    private static final Log log = LogFactory.getLog(SyncAgentTypeHelper.class);
    protected SyncAgentType syncAgentType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, SyncAgentType syncAgentType) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.syncAgentType = syncAgentType;
        this.setId(this.syncAgentType.getSYNCAGENTTYPEID());
        this.setName(this.syncAgentType.getSYNCAGENTTYPENAME());
        this.OnInit();
    }

    @Override
    public IDataSyncEngine CreateDataSyncEngine(DataSyncAgent dataSyncAgent) throws Exception {
        Object dataSyncEngineObj = ObjectHelper.Create((String)this.syncAgentType.getENGINEOBJECT());
        if (dataSyncEngineObj == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5f15\u64ce\u5bf9\u8c61[%1$s]", (Object)this.syncAgentType.getENGINEOBJECT()));
        }
        if (!(dataSyncEngineObj instanceof IDataSyncEngine)) {
            throw new Exception(StringHelper.Format((String)"\u5f15\u64ce\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.syncAgentType.getENGINEOBJECT()));
        }
        IDataSyncEngine iDataSyncEngine = (IDataSyncEngine)dataSyncEngineObj;
        return iDataSyncEngine;
    }
}

