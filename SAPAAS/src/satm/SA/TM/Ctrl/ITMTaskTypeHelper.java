/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTaskType;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMTaskBaseHelper;

public interface ITMTaskTypeHelper {
    public void Init(ISRFDAGlobalHelper var1, TMTaskType var2) throws Exception;

    public ITMTaskBaseHelper CreateTask() throws Exception;

    public String CreateTask(ITMActionContext var1, TMTaskBase var2) throws Exception;
}

