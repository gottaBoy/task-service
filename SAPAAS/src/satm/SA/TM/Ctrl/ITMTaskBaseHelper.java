/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.ITMGroupTaskHelper;
import SA.TM.Ctrl.ITMMainTaskHelper;
import SA.TM.Ctrl.ITMUserSessionStorage;
import java.util.Date;

public interface ITMTaskBaseHelper {
    public void Init(ISRFDAGlobalHelper var1, ITMUserSessionStorage var2, TMTaskBase var3) throws Exception;

    public String getId();

    public String getName();

    public Date getBeginTime();

    public Date getEndTime();

    public boolean isGroupTask();

    public boolean isMainTask();

    public ITMGroupTaskHelper getParentTask() throws Exception;

    public ITMMainTaskHelper getMainTask() throws Exception;

    public String getMainTaskId();

    public String getParentTaskId();

    public int getVersion();

    public String getTaskCenterId();

    public BaseDataEntity getSummaryInfo();
}

