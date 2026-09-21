/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBTTask;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTPlanHelper;
import SA.TM.Ctrl.ITMBTTaskResHelper;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMBTTaskInstHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBTTask var2) throws Exception;

    public String getId();

    public String getName();

    public String getBTMainTaskInstId();

    public Timestamp CalcStartTime(ITMActionContext var1, ITMBTPlanHelper var2, Timestamp var3) throws Exception;

    public int getTaskSN();

    public String getFrontTaskSN();

    public int getDuration();

    public Vector<ITMBTTaskResHelper> getBTTaskReses(ITMActionContext var1, boolean var2) throws Exception;

    public Vector<ITMBTTaskResHelper> getBTTaskReses(ITMActionContext var1) throws Exception;

    public boolean isIgnoreArrange();
}

