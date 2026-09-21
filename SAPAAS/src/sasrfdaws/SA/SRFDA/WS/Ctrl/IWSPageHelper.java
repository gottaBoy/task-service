/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSPage;
import SA.SRFDA.WS.Ctrl.Data.WSPageWB;
import SA.SRFDA.WS.Ctrl.IWSPagePublishContext;
import SA.SRFDA.WS.Ctrl.IWSPageTemplHelper;
import SA.SRFDA.WS.Ctrl.IWSWebSiteHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IWSPageHelper {
    public void Init(ISRFDAGlobalHelper var1, IWSWebSiteHelper var2, IWSPageTemplHelper var3, WSPage var4) throws Exception;

    public void Publish(IWSPagePublishContext var1) throws Exception;

    public WSPageWB FindWSPageWB(String var1);

    public String getPageId();

    public IWSWebSiteHelper getWSWebSiteHelper();

    public IWSPageTemplHelper getWSPageTemplHelper();

    public WSPage getWSPage();

    public String getPublishedPageUrl();

    public String getId();

    public String getName();
}

