/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Core.SubSys.IPSSubDE;
import SA.SRFDA.PS.Core.SubSys.IPSSubDEView;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysSF;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysVer;
import SA.SRFDA.PS.Data.PSSubSys;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSubSys
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSSubSys var2) throws Exception;

    public IPSSubDEView getPSSubDEView(String var1) throws Exception;

    public void resetPSSubDEView(String var1);

    public IPSSubDE getPSSubDE(String var1) throws Exception;

    public void resetPSSubDE(String var1);

    public IPSSubSysSF getPSSubSysSF(String var1) throws Exception;

    public void resetPSSubSysSF(String var1);

    public Iterator<IPSSubSysSF> getAllPSSubSysSFs() throws Exception;

    public IPSSubSysSF getPSSubSysSFBySFStyle(String var1, boolean var2) throws Exception;

    public IPSSubApp getPSSubApp(String var1) throws Exception;

    public void resetPSSubApp(String var1);

    public Iterator<IPSSubDEView> getAllPSSubDEViews() throws Exception;

    public void loadAll() throws Exception;

    public boolean isLoadAll();

    public IPSSubSysVer getPSSubSysVerByVer(int var1) throws Exception;

    public IPSSubSysVer getPSSubSysVer(String var1) throws Exception;

    public void resetPSSubSysVer(String var1);

    public Iterator<IPSSubSysVer> getAllPSSubSysVers() throws Exception;
}

