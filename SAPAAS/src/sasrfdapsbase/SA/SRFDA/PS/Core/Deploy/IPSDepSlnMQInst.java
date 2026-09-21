/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnResObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDepSlnMQInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDepSlnMQInst
extends IPSDepSlnResObject {
    public void init(ISRFDAGlobalHelper var1, IPSDepSln var2, PSDepSlnMQInst var3) throws Exception;

    public String getMQType(boolean var1) throws Exception;

    public String getConnUrl(boolean var1) throws Exception;

    public String getUserName(boolean var1) throws Exception;

    public String getPassword(boolean var1) throws Exception;
}

