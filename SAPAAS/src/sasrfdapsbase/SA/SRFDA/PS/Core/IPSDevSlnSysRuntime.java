/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.Deploy.IPSDCDeployServer;
import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnSysWSGit;
import SA.SRFDA.PS.Core.Deploy.IPSMavenRepo;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspace;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.PS.Data.PSDevSlnTempl;
import java.util.ArrayList;

@PSModelIgnoreMeta
public interface IPSDevSlnSysRuntime {
    public String getRootFolder();

    @Deprecated
    public IPSDCDeployServer getPSDCDeployServer();

    public IPSDeployCenter getPSDeployCenter();

    public IPSWorkshopServer getPSWorkshopServer();

    public boolean isUseWorkshopServer();

    public boolean isUseDeployCenter();

    public IPSDevSlnSysWSGit getPSDevSlnSysWSGit();

    public IPSMavenRepo getDeployPSMavenRepo();

    public IPSMavenRepo getDCDeployPSMavenRepo();

    public ArrayList<PSDevSlnTempl> getPSDevSlnTemplList();

    public void setDebugMode(boolean var1);

    public IPSWorkspace getPSWorkspace();

    public String getRuntimePSSysModelInstId();

    public ArrayList<PSDevSlnSysDynaInst> getPSDevSlnSysDynaInstList();

    public boolean isDynaInstMode();

    public String getPSDynaInstId();

    public String getPSDynaInstName();

    public String getPSDynaInstLogicName();

    public String getPPSDynaInstId();

    public int getDynaInstMode();

    public String getDynaInstTag();

    public String getDynaInstTag2();

    public IPSSFStyle getPSSFStyle(String var1, String var2, String var3) throws Exception;

    public IPSPFStyle getPSPFStyle(String var1, String var2, String var3) throws Exception;

    public void reloadSystemTempls() throws Exception;
}

