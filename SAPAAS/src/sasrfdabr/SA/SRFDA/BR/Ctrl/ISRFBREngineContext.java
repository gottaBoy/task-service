/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.BR.Ctrl;

import SA.SRFDA.BR.Ctrl.Data.BRInstParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Vector;

public interface ISRFBREngineContext {
    public ISRFDAGlobalHelper getDAGlobalHelper();

    public void Schedule();

    public Vector<BRInstParam> getInstParams();

    public void setAttribute(String var1, Object var2);

    public Object getAttribute(String var1);

    public Object getParam(String var1);
}

