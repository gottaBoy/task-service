/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandlerAction;
import SA.SRFDA.PS.Core.Control.IPSControlHandlerAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u5668\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAjaxHandler
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, Object var2, PSACHandler var3) throws Exception;

    public String getHandlerObj();

    public Iterator<IPSAjaxHandlerAction> getPSAjaxHandlerActions();

    public Iterator<? extends IPSControlHandlerAction> getPSHandlerActions();

    public IPSAjaxHandlerAction getPSAjaxHandlerAction(String var1, boolean var2) throws Exception;

    public IPSAppView getPSAppView();

    public String getHandlerTag();

    public String getHandlerTag2();
}

