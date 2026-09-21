/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util;

import net.ibizsys.pscore.srv.util.IPSDevUserBase;

public interface IPSDevUser
extends IPSDevUserBase {
    @Override
    public String getPSDevCenterId();

    public int getAccMode();

    public String getPSDCInstId();

    public boolean isShareAccMode();

    public boolean isMaintainAccMode();

    public boolean isDefaultMode();

    public boolean isAdminMode();

    public String getPSDCType();

    public int getPSDCLevel();
}

