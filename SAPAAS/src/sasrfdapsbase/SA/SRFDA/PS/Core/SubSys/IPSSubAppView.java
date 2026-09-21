/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSubAppView
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubApp var2, PSSubAppView var3) throws Exception;

    public String getPageUrl();

    public String getPSSubDEViewId();

    public String getAppModuleName();

    public String getAppModuleCodeName();
}

