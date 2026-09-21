/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSPageType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IWSPageTypeHelper {
    public void Init(ISRFDAGlobalHelper var1, WSPageType var2) throws Exception;

    public WSPageType getWSPageType() throws Exception;

    public String getHelperObject();

    public String getPageObject();
}

