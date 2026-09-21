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
import SA.SRFDA.PS.Data.PSDepSlnDBInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDepSlnDBInst
extends IPSDepSlnResObject {
    public void init(ISRFDAGlobalHelper var1, IPSDepSln var2, PSDepSlnDBInst var3) throws Exception;

    public String getDBType(boolean var1) throws Exception;

    public String getConnUrl(boolean var1) throws Exception;

    public String getUserName(boolean var1) throws Exception;

    public String getPassword(boolean var1) throws Exception;
}

