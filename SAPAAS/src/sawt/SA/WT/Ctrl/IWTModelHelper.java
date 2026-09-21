/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.WT.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.WT.Data.WTAccount;
import SA.WT.Data.WTConfigType;
import SA.WT.Data.WTConfigValue;
import SA.WT.Data.WTServiceBase;
import SA.WT.Data.WTServiceStep;
import SA.WT.Data.WTServiceType;
import SA.WT.Data.WTStandardService;
import java.util.Vector;

public interface IWTModelHelper {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public CallResult GetWTConfigType(String var1, WTConfigType var2);

    public CallResult GetWTConfigValues(String var1, Vector<WTConfigValue> var2);

    public CallResult GetWTAccount(String var1, WTAccount var2);

    public CallResult GetWTServiceType(String var1, WTServiceType var2);

    public CallResult GetWTServiceBase(String var1, WTServiceBase var2);

    public CallResult GetWTServiceBaseByCode(String var1, WTServiceBase var2);

    public CallResult GetWTStandardService(String var1, WTStandardService var2);

    public CallResult GetWTServiceSteps(String var1, Vector<WTServiceStep> var2);

    public CallResult GetPredefinedWTService(String var1, Vector<WTServiceBase> var2);
}

