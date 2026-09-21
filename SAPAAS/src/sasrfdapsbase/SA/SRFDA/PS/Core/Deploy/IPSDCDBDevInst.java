/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDCAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDCDBDevInst
extends IPSDBDevInst,
IPSRemoteResObject {
    public void init(ISRFDAGlobalHelper var1, PSDevCenterDBInst var2) throws Exception;

    public void init(ISRFDAGlobalHelper var1, IPSDCAppServer var2, PSDevCenterDBInst var3) throws Exception;

    @Override
    public String getDBClientPath();

    public IPSDCAppServer getPSDCAppServer();
}

