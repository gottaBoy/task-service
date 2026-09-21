/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDevServer;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDevServer;
import SA.SRFDA.PS.Data.PSDevServerType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDevServerType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDevServerType var2) throws Exception;

    public IPSDevServer createPSDevServer(PSDevServer var1) throws Exception;

    public String getInstallPath();

    public void initBookingRes(PSDevServer var1) throws Exception;

    public void restoreBookingRes(PSDevServer var1) throws Exception;

    public void backupBookingRes(PSDevServer var1) throws Exception;

    public void uninitBookingRes(PSDevServer var1) throws Exception;
}

