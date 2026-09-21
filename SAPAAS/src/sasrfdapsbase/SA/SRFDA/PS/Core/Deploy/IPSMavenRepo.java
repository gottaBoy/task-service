/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.Deploy.IPSMavenServer;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSMavenRepo
extends IPSObject,
IPSDCResObject {
    public void init(ISRFDAGlobalHelper var1, PSMavenRepo var2) throws Exception;

    public String getConnStr();

    public String getMavenServerType();

    public String getUserName();

    public String getPassword();

    public IPSMavenServer getPSMavenServer();

    public String getAdminUserName();

    public String getAdminPassword();
}

