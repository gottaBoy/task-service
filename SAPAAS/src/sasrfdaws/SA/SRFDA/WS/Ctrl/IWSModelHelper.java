/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.WS.Ctrl.Data.WSChannel;
import SA.SRFDA.WS.Ctrl.Data.WSPage;
import SA.SRFDA.WS.Ctrl.Data.WSPageTempl;
import SA.SRFDA.WS.Ctrl.Data.WSPageType;
import SA.SRFDA.WS.Ctrl.Data.WSPageWB;
import SA.SRFDA.WS.Ctrl.Data.WSRuntime;
import SA.SRFDA.WS.Ctrl.Data.WSWBType;
import SA.SRFDA.WS.Ctrl.Data.WSWebPart;
import SA.SRFDA.WS.Ctrl.Data.WSWebSite;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IWSModelHelper {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public CallResult GetWSPageType(String var1, WSPageType var2);

    public CallResult GetWSPageTempl(String var1, WSPageTempl var2);

    public CallResult GetWSPageTempls(String var1, Vector<WSPageTempl> var2);

    public CallResult GetWSWBType(String var1, WSWBType var2);

    public CallResult GetWSWebPart(String var1, WSWebPart var2);

    public CallResult GetWSWebSite(String var1, WSWebSite var2);

    public CallResult GetWSChannel(String var1, Vector<WSChannel> var2);

    public CallResult GetWSPage(String var1, WSPage var2);

    public CallResult GetWSPages(String var1, Vector<WSPage> var2);

    public CallResult GetWSWebSiteRuntimes(String var1, Vector<WSRuntime> var2);

    public CallResult GetWSPageWBs(String var1, Vector<WSPageWB> var2);

    public CallResult GetWSWebParts(String var1, Vector<WSWebPart> var2);
}

