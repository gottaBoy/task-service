/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.pscore.srv.util.IPSDevUserBase;

public interface IPSSysDevUser
extends IPSDevUserBase {
    public int getAccMode();

    public String getPSSystemId();

    public String getPSDevSlnSysId();

    public String getJITTaskServerUrl();

    public String getPSSysModelInstId();

    public boolean isShareAccMode();

    public boolean isMaintainAccMode();

    public String getPSDevSlnTemplId();

    public String getPSDevSlnId();

    public String getPSDCWorkspaceId();

    public boolean isEnableAPI();

    public String getLoginName();

    public boolean isOwnerAccMode();

    public String getPSDynaInstId();

    public String getPSDepInstId();
}

