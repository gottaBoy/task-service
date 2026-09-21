/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSPageTempl;
import SA.SRFDA.WS.Ctrl.IWSPageTypeHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IWSPageTemplHelper {
    public void Init(ISRFDAGlobalHelper var1, IWSPageTypeHelper var2, WSPageTempl var3) throws Exception;

    public IWSPageTypeHelper getWSPageTypeHelper();

    public WSPageTempl getWsPageTempl() throws Exception;
}

