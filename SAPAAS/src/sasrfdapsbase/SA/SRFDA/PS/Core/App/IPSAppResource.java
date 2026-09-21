/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSAppResource;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5e94\u7528\u9884\u7f6e\u8d44\u6e90\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSAppResource")
public interface IPSAppResource
extends IPSApplicationObject {
    public void init(ISRFDAGlobalHelper var1, IPSApplication var2, PSAppResource var3) throws Exception;

    public String getResourceType();

    public String getResTag();

    public String getContent();
}

