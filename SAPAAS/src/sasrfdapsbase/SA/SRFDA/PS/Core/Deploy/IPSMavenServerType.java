/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSMavenServer;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.PS.Data.PSMavenServer;
import SA.SRFDA.PS.Data.PSMavenServerType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSMavenServerType
extends IPSObject {
    public static final String MAVENSERVERTYPE_NEXUS = "NEXUS";
    public static final int UPDATEMAVENREPOMODE_ADMINPASS = 1;
    public static final int UPDATEMAVENREPOMODE_GUESTPASS = 2;

    public void init(ISRFDAGlobalHelper var1, PSMavenServerType var2) throws Exception;

    public IPSMavenServer createPSMavenServer(PSMavenServer var1) throws Exception;

    public String getInstallPath(String var1);

    public void createMavenRepo(PSMavenRepo var1) throws Exception;

    public void updateMavenRepo(PSMavenRepo var1, int var2) throws Exception;
}

