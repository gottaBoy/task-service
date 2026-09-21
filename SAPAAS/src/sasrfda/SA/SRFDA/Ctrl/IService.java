/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.Service;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IService {
    public CallResult Init(Service var1, ISRFDAGlobalHelper var2);

    public CallResult Quit();

    public CallResult Start();

    public CallResult Stop();

    public boolean IsStart();

    public String getServiceId();
}

