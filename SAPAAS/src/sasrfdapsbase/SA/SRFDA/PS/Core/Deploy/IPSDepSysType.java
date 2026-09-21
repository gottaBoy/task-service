/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSysApp;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSysApp;
import SA.SRFDA.PS.Data.PSDepSysType;
import SA.SRFDA.PS.Data.PSDepSysVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDepSysType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDepSysType var2) throws Exception;

    public IPSDepSysVer createPSDepSysVer(PSDepSysVer var1) throws Exception;

    public IPSDepSysApp createPSDepSysApp(PSDepSysApp var1) throws Exception;
}

