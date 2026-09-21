/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.TM.Ctrl.Data.TMResBase;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.ITMActionContext;
import SA.TM.Ctrl.ITMResTypeHelper;
import java.sql.Timestamp;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMResBaseHelper {
    public void Init(ISRFDAGlobalHelper var1, ITMResTypeHelper var2, TMResBase var3) throws Exception;

    public String getId();

    public String getName();

    public boolean isComplexResource();

    public CallResult TestBooking(ITMActionContext var1, TMResBooking var2) throws Exception;

    public TMResBooking Booking(ITMActionContext var1, TMResBooking var2) throws Exception;

    public TMResBooking UpdateBooking(ITMActionContext var1, TMResBooking var2, TMResBooking var3) throws Exception;

    public void CancelBooking(ITMActionContext var1, TMResBooking var2) throws Exception;

    public int getVersion();

    public Vector<String> getRBRules();

    public boolean TestValidTime(Timestamp var1, Timestamp var2) throws Exception;

    public String getTimeRuleId();

    public float getCapacity();

    public float getCapacity2();

    public int getCapacity3();

    public int getCapacity4();

    public String getResType();

    public String getDetailInfo();
}

