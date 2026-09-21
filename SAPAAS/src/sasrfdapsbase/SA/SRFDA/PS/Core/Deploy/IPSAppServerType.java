/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.PS.Data.PSAppServerType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSAppServerType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSAppServerType var2) throws Exception;

    public IPSAppServer createPSAppServer(PSAppServer var1) throws Exception;

    public String getInstallPath(String var1);

    public String getStartupCmd(String var1, String var2);

    public String getShutdownCmd(String var1, String var2);

    public void initBookingRes(PSAppServer var1) throws Exception;

    public void restoreBookingRes(PSAppServer var1) throws Exception;

    public void backupBookingRes(PSAppServer var1) throws Exception;

    public void uninitBookingRes(PSAppServer var1) throws Exception;
}

