/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SubSys.IPSSubAppView;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysObject;
import SA.SRFDA.PS.Data.PSSubApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSSubApp
extends IPSSubSysObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubSys var2, PSSubApp var3) throws Exception;

    public IPSSubAppView getPSSubAppView(String var1) throws Exception;

    public void resetPSSubAppView(String var1);

    public Iterator<IPSSubAppView> getAllPSSubAppViews() throws Exception;

    public String getAppPKGName();

    public IPSSubAppView getPSSubAppViewBySubDEView(String var1, boolean var2) throws Exception;
}

