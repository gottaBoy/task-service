/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.App.Control;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.sf.json.JSONObject;

@PSModelInterfaceMeta(title="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppCounterRef
extends IPSSysCounterRef {
    public void init(ISRFDAGlobalHelper var1, IPSAppCounter var2, JSONObject var3) throws Exception;

    public IPSAppCounter getPSAppCounter();
}

