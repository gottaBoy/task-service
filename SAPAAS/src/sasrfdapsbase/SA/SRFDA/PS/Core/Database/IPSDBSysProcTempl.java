/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBSPPartTempl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSDBSysProcCodePublisher;
import SA.SRFDA.PS.Data.PSDBSysProcTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDBSysProcTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSDBType var2, PSDBSysProcTempl var3) throws Exception;

    public IPSDBType getPSDBType();

    public String getPSDBSysProcTypeId();

    public IPSDBSPPartTempl getPSDBSPPartTempl(String var1) throws Exception;

    public void resetPSDBSPPartTempl(String var1) throws Exception;

    public IPSDBSysProcCodePublisher getPSDBSysProcCodePublisher() throws Exception;

    public void releasePSDBSysProcCodePublisher(IPSDBSysProcCodePublisher var1);

    public PSDBSysProcTempl getPSDBSysProcTemplData();
}

