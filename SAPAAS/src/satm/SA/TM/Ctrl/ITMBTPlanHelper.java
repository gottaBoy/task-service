/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTPlan;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTMainTaskInstPlanHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstPlanHelper;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMBTPlanHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTPlan var2) throws Exception;

    public String getId();

    public String getName();

    public void CreateDefault(ITMActionContext var1, Timestamp var2, Timestamp var3) throws Exception;

    public ITMBTPlanHelper CreateChildBTPlan(ITMActionContext var1) throws Exception;

    public ITMBTPlanHelper CloneBTPlan(ITMActionContext var1) throws Exception;

    public void RemoveChildBTPlan(ITMActionContext var1, String var2) throws Exception;

    public ITMBTPlanHelper getParentBTPlan(ITMActionContext var1) throws Exception;

    public Vector<ITMBTPlanHelper> getChildBTPlans(ITMActionContext var1) throws Exception;

    public Vector<ITMBTPlanHelper> getChildBTPlans(ITMActionContext var1, boolean var2) throws Exception;

    public ITMBTMainTaskInstPlanHelper FindBTMainTaskInstPlan(ITMActionContext var1, String var2) throws Exception;

    public ITMBTMainTaskInstPlanHelper FinishBTMainTaskInst(ITMActionContext var1, String var2) throws Exception;

    public ITMBTTaskInstPlanHelper FinishBTTaskInst(ITMActionContext var1, ITMBTTaskInstHelper var2, Timestamp var3) throws Exception;

    public Vector<ITMBTTaskInstPlanHelper> ListBTTaskInstPlans(ITMActionContext var1, String var2, String var3) throws Exception;

    public Timestamp getBTMainTaskBeginTime();

    public Timestamp getBTMainTaskEndTime();

    public void MarkBTPlanFinish(ITMActionContext var1) throws Exception;
}

