/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMTTRC;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTaskType;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMTaskBaseHelper;
import SA.TM.Ctrl.ITMTaskTypeHelper;
import java.util.Vector;

public class TMTaskTypeHelper
extends BaseTMObject
implements ITMTaskTypeHelper {
    protected TMTaskType tmTaskType = null;
    protected Vector<TMTTRC> tmTTRCList = new Vector();

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMTaskType tmTaskType) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmTaskType = tmTaskType;
        this.OnPrepareTMTTRCs();
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    protected void OnPrepareTMTTRCs() throws Exception {
        CallResult callResult = this.getTMModelHelper().GetTMTTRCs(this.tmTaskType.getTMTASKTYPEID(), this.tmTTRCList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4efb\u52a1\u7c7b\u578b\u8d44\u6e90\u5206\u7c7b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    public ITMTaskBaseHelper CreateTask() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.tmTaskType.getTASKOBJECT())) {
            Object objTaskHelper = ObjectHelper.Create((String)this.tmTaskType.getTASKOBJECT());
            if (objTaskHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1\u5bf9\u8c61[%1$s]", (Object)this.tmTaskType.getTASKOBJECT()));
            }
            if (!(objTaskHelper instanceof ITMTaskBaseHelper)) {
                throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.tmTaskType.getTASKOBJECT()));
            }
            return (ITMTaskBaseHelper)objTaskHelper;
        }
        throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4efb\u52a1\u5bf9\u8c61");
    }

    public String CreateTask(ITMActionContext iTMActionContext, TMTaskBase tmTaskBase) throws Exception {
        throw new Exception("\u6ca1\u6709\u5efa\u7acb\u4efb\u52a1\u5bf9\u8c61\u7684\u65b9\u6cd5");
    }
}

