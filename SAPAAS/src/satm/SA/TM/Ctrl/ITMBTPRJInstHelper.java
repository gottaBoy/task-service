/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTPRJInst;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTMainTaskInstHelper;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTProjectHelper;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMBTPRJInstHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTPRJInst var2) throws Exception;

    public String getId();

    public String getName();

    public Timestamp getBeginTime() throws Exception;

    public Timestamp getEndTime() throws Exception;

    public ITMBTProjectHelper getBTProject() throws Exception;

    public Vector<ITMBTMainTaskInstHelper> getBTMainTaskInsts() throws Exception;

    public Vector<ITMBTMainTaskInstHelper> getBTMainTaskInsts(boolean var1) throws Exception;

    public ITMBTPlanHelper getDefaultBTPlan(ITMActionContext var1) throws Exception;

    public int getAPMainTaskSuccessLoopCnt(int var1);

    public int getAPMainTaskFailedLoopCnt(int var1);

    public int getAPTaskSuccessLoopCnt(int var1);

    public int getAPTaskFailedLoopCnt(int var1);
}

