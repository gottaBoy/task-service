/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.ITMMainTaskHelper;
import SA.TM.Ctrl.ITMTaskBaseHelper;
import SA.TM.Ctrl.ITMTaskTypeHelper;
import SA.TM.Ctrl.ITMUserSessionStorage;
import java.util.Hashtable;

public class TMUserSessionStorage
extends BaseTMObject
implements ITMUserSessionStorage {
    protected String strPersonId = "";
    protected Hashtable<String, ITMTaskBaseHelper> tmTaskBaseHelperMap = new Hashtable();

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, String strPersonId) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.strPersonId = strPersonId;
    }

    public ITMTaskBaseHelper FindTMTask(String strTMTaskBaseId, int nVersion) throws Exception {
        return this.FindTMTask(this.getTMModelStorage().FindTMTask(strTMTaskBaseId, nVersion));
    }

    public ITMTaskBaseHelper FindTMTask(String strTMTaskBaseId) throws Exception {
        return this.FindTMTask(this.getTMModelStorage().FindTMTask(strTMTaskBaseId));
    }

    public ITMTaskBaseHelper FindTMTask(TMTaskBase tmTaskBase) throws Exception {
        ITMTaskBaseHelper iTMTaskBaseHelper = this.tmTaskBaseHelperMap.get(tmTaskBase.getTMTASKBASEID());
        if (iTMTaskBaseHelper != null && iTMTaskBaseHelper.getVersion() == tmTaskBase.getVERSION()) {
            return iTMTaskBaseHelper;
        }
        iTMTaskBaseHelper = this.OnCreateTMTaskHelper(tmTaskBase);
        iTMTaskBaseHelper.Init(this.iDAGlobalHelper, this, tmTaskBase);
        this.tmTaskBaseHelperMap.put(tmTaskBase.getTMTASKBASEID(), iTMTaskBaseHelper);
        return iTMTaskBaseHelper;
    }

    protected ITMTaskBaseHelper OnCreateTMTaskHelper(TMTaskBase tmTaskBase) throws Exception {
        ITMTaskTypeHelper iTMTaskTypeHelper = this.getTMModelStorage().FindTMTaskType(tmTaskBase.getTMTASKBASETYPE());
        return iTMTaskTypeHelper.CreateTask();
    }

    public ITMMainTaskHelper FindTMMainTask(String strTMTaskBaseId) throws Exception {
        ITMTaskBaseHelper iTMTaskBaseHelper = this.FindTMTask(strTMTaskBaseId);
        if (iTMTaskBaseHelper instanceof ITMMainTaskHelper) {
            return (ITMMainTaskHelper)iTMTaskBaseHelper;
        }
        throw new Exception(StringHelper.Format((String)"\u4efb\u52a1[%1$s]\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strTMTaskBaseId));
    }
}

