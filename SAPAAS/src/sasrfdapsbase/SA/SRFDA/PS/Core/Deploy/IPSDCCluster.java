/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSRemoteResObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Data.PSDCCluster;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSDCCluster
extends IPSObject,
IPSRemoteResObject,
IPSDCResObject {
    public void init(ISRFDAGlobalHelper var1, PSDCCluster var2) throws Exception;

    public String getSSHIPAddr();

    public int getSSHPort();

    public String getLocalSSHIPAddr();

    public int getLocalSSHPort();

    public String getSSHUserName();

    public String getSSHPassword();
}

