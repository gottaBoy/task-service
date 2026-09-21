/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDeployServer;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnSysWSGit;
import SA.SRFDA.PS.Core.Deploy.IPSMavenRepo;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspace;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.PS.Data.PSDevSlnTempl;
import java.util.ArrayList;

public interface IPSSystemRuntime {
    public boolean isRemotePack();

    public boolean isRemoteDeploy();

    @Deprecated
    public IPSDeployServer getPSDeployServer();

    public IPSDeployCenter getPSDeployCenter();

    public IPSWorkshopServer getPSWorkshopServer();

    public boolean isUseWorkshopServer();

    public IPSDevSlnSysWSGit getPSDevSlnSysWSGit();

    public IPSMavenRepo getDeployPSMavenRepo();

    public IPSMavenRepo getDCDeployPSMavenRepo();

    public ArrayList<PSDevSlnTempl> getPSDevSlnTemplList();

    public IPSWorkspace getPSWorkspace();

    public IPSModelObjectLogger getPSModelObjectLogger();

    public void setPSModelObjectLogger(IPSModelObjectLogger var1);

    public ArrayList<PSDevSlnSysDynaInst> getPSDevSlnSysDynaInstList();

    public boolean isDynaInstMode();

    public String getPSDynaInstId();

    public String getPSDynaInstName();

    public String getPSDynaInstLogicName();

    public String getPPSDynaInstId();

    public int getDynaInstMode();

    public String getDynaInstTag();

    public String getDynaInstTag2();
}

