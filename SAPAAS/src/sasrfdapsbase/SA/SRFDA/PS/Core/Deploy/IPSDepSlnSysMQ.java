/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnMQInst;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSlnSysMQ;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDepSlnSysMQ
extends IPSDepSlnSysObject {
    public void init(ISRFDAGlobalHelper var1, IPSDepSln var2, PSDepSlnSysMQ var3) throws Exception;

    public IPSDepSlnMQInst getPSDepSlnMQInst();
}

