/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSWebSite;
import SA.SRFDA.WS.Ctrl.IWSPageHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IWSWebSiteHelper {
    public void Init(ISRFDAGlobalHelper var1, WSWebSite var2) throws Exception;

    public void Publish() throws Exception;

    public IWSPageHelper FindWSPageHelper(String var1) throws Exception;

    public WSWebSite getWSWebSite();

    public String getName();

    public String getRootPath();
}

