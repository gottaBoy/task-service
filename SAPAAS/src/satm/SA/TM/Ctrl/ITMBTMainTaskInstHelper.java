/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.TM.Ctrl.Data.TMBookingTest;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMBTPRJInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMBTMainTaskInstHelper {
    public void Init(ISRFDAGlobalHelper var1, TMBookingTest var2) throws Exception;

    public String getId();

    public String getName();

    public Vector<ITMBTTaskInstHelper> getBTTaskInsts(ITMActionContext var1) throws Exception;

    public Vector<ITMBTTaskInstHelper> getBTTaskInsts(ITMActionContext var1, boolean var2) throws Exception;

    public boolean isMatch(ITMBTMainTaskInstHelper var1);

    public boolean isExtracted();

    public void ExtractBTTaskInsts(ITMActionContext var1) throws Exception;

    public Timestamp getBeginTime() throws Exception;

    public Timestamp getEndTime() throws Exception;

    public boolean isCancelable();

    public int getMinDuration();

    public int getMaxDuration();

    public String getUniqueTag();

    public ITMBTPRJInstHelper getBTPRJInst() throws Exception;
}

