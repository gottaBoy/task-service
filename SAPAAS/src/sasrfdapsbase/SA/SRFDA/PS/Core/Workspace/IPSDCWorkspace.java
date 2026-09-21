/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceSum
 */
package SA.SRFDA.PS.Core.Workspace;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceSum;

@PSModelIgnoreMeta
public interface IPSDCWorkspace
extends IPSWorkspace,
IPSDCResObject {
    public static final String ACTIONCAT_SYSBKTASK = "SYSBKTASK";
    public static final String ACTIONCAT_DCBKTASK = "DCBKTASK";

    public String getPSDevCenterId();

    public String getPSDevSlnId();

    public String getPSDevSlnSysId();

    public boolean testAction(String var1, String var2, int var3, boolean var4) throws Exception;

    public void logAction(String var1, String var2, String var3, int var4);

    public PSWorkspaceSum getAction(String var1, String var2, String var3);
}

