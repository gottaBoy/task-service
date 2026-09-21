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
import SA.TM.Ctrl.Data.TMRBRule;
import SA.TM.Ctrl.Data.TMResBooking;
import SA.TM.Ctrl.ITMActionContext;
import java.util.Vector;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ITMRBRuleHelper {
    public void Init(ISRFDAGlobalHelper var1, TMRBRule var2) throws Exception;

    public CallResult Check(ITMActionContext var1, TMResBooking var2, boolean var3, Vector<TMResBooking> var4) throws Exception;

    public int getVersion();

    public String getId();

    public String getRuleInfo();

    public String getName();
}

