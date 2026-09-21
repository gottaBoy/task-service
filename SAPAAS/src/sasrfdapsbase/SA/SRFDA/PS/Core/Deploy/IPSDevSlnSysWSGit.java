/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDevSlnSysWSGit;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDevSlnSysWSGit
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSDevSlnSys var2, PSDevSlnSysWSGit var3) throws Exception;

    public IPSDevSlnSys getPSDevSlnSys() throws Exception;

    public IPSWorkshopServer getPSWorkshopServer() throws Exception;

    public String getGitPath();

    public String getGitUserName();

    public String getGitPassword();
}

