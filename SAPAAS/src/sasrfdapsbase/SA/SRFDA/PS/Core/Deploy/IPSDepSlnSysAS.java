/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnAS;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnASGroup;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysObject;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysApp;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSlnSysAS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDepSlnSysAS
extends IPSDepSlnSysObject {
    public static final String CONTAINERTYPE_AS = "AS";
    public static final String CONTAINERTYPE_ASGROUP = "ASGROUP";

    public void init(ISRFDAGlobalHelper var1, IPSDepSln var2, PSDepSlnSysAS var3) throws Exception;

    public String getServiceContainer();

    public IPSDepSysVer getPSDepSysVer();

    public IPSDepSysApp getPSDepSysApp();

    public IPSDepSysApp getNo2PSDepSysApp();

    public IPSDepSlnASGroup getPSDepSlnASGroup();

    public IPSDepSlnAS getPSDepSlnAS();

    public String getContainerType();
}

