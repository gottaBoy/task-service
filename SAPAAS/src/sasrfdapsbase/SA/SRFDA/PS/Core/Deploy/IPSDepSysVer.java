/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSysApp;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSysVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSDepSysVer
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, PSDepSysVer var2) throws Exception;

    public Iterator<IPSDepSysApp> getAllPSDepSysApps() throws Exception;

    public IPSDepSysApp getPSDepSysApp(String var1) throws Exception;

    public void resetPSDepSysApp(String var1) throws Exception;

    public void resetAllPSDepSysApps();

    public String getPSDepSysId();

    public String getPSDepSysName();

    public String getPSDevSlnSysId();
}

