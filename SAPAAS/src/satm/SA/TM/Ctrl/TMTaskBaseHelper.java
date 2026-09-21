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
import SA.TM.Ctrl.ITMGroupTaskHelper;
import SA.TM.Ctrl.ITMMainTaskHelper;
import SA.TM.Ctrl.ITMTaskBaseHelper;
import SA.TM.Ctrl.ITMUserSessionStorage;
import java.util.Date;

public abstract class TMTaskBaseHelper
extends BaseTMObject
implements ITMTaskBaseHelper {
    protected TMTaskBase tmTaskBase = null;
    protected String strTMGroupTaskId = "";
    protected ITMUserSessionStorage iTMUserSessionStorage = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, ITMUserSessionStorage iTMUserSessionStorage, TMTaskBase tmTaskBase) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmTaskBase = tmTaskBase;
        this.iTMUserSessionStorage = iTMUserSessionStorage;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    public String getId() {
        return this.tmTaskBase.getTMTASKBASEID();
    }

    public String getName() {
        return this.tmTaskBase.getTMTASKBASENAME();
    }

    public Date getBeginTime() {
        return null;
    }

    public Date getEndTime() {
        return null;
    }

    public String getMainTaskId() {
        return this.tmTaskBase.getROOTTMTASKBASEID();
    }

    public String getParentTaskId() {
        return this.tmTaskBase.getPTMTASKBASEID();
    }

    public ITMMainTaskHelper getMainTask() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getMainTaskId())) {
            return null;
        }
        return (ITMMainTaskHelper)((Object)this.getTMModelStorage().FindTMTask(this.getMainTaskId()));
    }

    public ITMGroupTaskHelper getParentTask() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getParentTaskId())) {
            return null;
        }
        return (ITMGroupTaskHelper)((Object)this.getTMModelStorage().FindTMTask(this.getParentTaskId()));
    }

    public int getVersion() {
        return this.tmTaskBase.getVERSION();
    }

    public String getTaskCenterId() {
        return this.tmTaskBase.getTMTASKCENTERID();
    }
}

